package com;

import javax.jws.WebParam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Tela extends JPanel {
    //=============painel main{
    JPanel main;
    JLabel nomeL;
    JTextField nome;
    JLabel pesquisar;
    JLabel precoL;
    JTextField preco;
    //=============}
    //=============painel main{
    JPanel table;
    //=============}
    //=============painel main{
    JPanel boton;
    JButton editar;
    JButton atualizar;
    JButton deletar;
    JButton voltar;
    JButton add;

    DefaultListModel modeloLista = new DefaultListModel();
    JList<String> tableL;
    //=============}
    BD banco;
    List <Produto>Itens;
    Date data;

    TelaMain telaMain;

    public Tela(TelaMain telaMain){
        this.telaMain = telaMain;
        setLayout(new BorderLayout());

        main = new JPanel(new GridBagLayout());
        elementosPainelMain();
        table = new JPanel(new FlowLayout());
        elementosPainelTable();
        boton = new JPanel();
        elementosPainelBoton();

        add(main, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setSelecionado(BD bd){
        this.banco=bd;
        return;
    }

    public void elementosPainelMain(){
        GridBagConstraints place = new GridBagConstraints();
        nomeL = new JLabel("Nome:");
        nome = new JTextField(15);


        pesquisar = new JLabel(new ImageIcon(getClass().getResource("buscarpreto.png")));
        pesquisar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                Itens = new ArrayList<>();
                Itens = banco.pesquisa(nome.getText());

                modeloLista.removeAllElements();
                if(Itens.size()!=0){
                    for (Produto Item: Itens) {
                        modeloLista.addElement(Item.produtoToStringNormal());
                    }
                }else{
                    modeloLista.addElement(new String("Nenhum produto encontrado"));
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                pesquisar.setIcon(new ImageIcon(getClass().getResource("buscar.png")));
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                pesquisar.setIcon(new ImageIcon(getClass().getResource("buscarpreto.png")));
            }
        });

        configPosicao(place,0,0);
        main.add(nomeL, place);
        configPosicao(place,1,0);
        main.add(nome, place);
        configPosicao(place,2,0);
        main.add(pesquisar, place);


    }

    public void elementosPainelTable(){
        tableL = new JList(modeloLista);
        tableL.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.add(new JScrollPane(tableL));
    }

    public void elementosPainelBoton(){

        editar = new JButton("Editar");
        atualizar = new JButton("Adicionar");
        deletar = new JButton("Deletar");
        voltar = new JButton("Voltar");

        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TelaCadastro();
            }
        });
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TelaEditar();
            }
        });
        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                banco.deletar(Itens.get(tableL.getSelectedIndex()).getID());

                Itens.remove(tableL.getSelectedIndex());
                modeloLista.removeAllElements();
                if(Itens.size()!=0){
                    for (Produto Item: Itens) {
                        modeloLista.addElement(Item.produtoToStringNormal());
                    }
                }
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modeloLista.removeAllElements();
                telaMain.voltarMain();
            }
        });

        boton.add(editar);
        boton.add(atualizar);
        boton.add(deletar);
        boton.add(voltar);
    }

    public void configPosicao(GridBagConstraints place, int x, int y){
        place.gridx = x;
        place.gridy = y;
        place.ipadx = 15;
        place.ipady = 15;
    }

    public void TelaCadastro(){

        JLabel info = new JLabel("Cadastre um novo produto");
        JLabel nomeCadastro = new JLabel("Nome do produto :");
        JTextField campoNome = new JTextField(15);
        campoNome.setText(nome.getText());
        JLabel precoCadastro = new JLabel("Preço do produto :");
        JTextField campoPreco = new JTextField(10);
        JPanel centro = new JPanel(new GridBagLayout());
        GridBagConstraints local = new GridBagConstraints();
        JDialog cadastro = new JDialog();

        cadastro.setLayout(new BorderLayout());
        cadastro.add(info,BorderLayout.NORTH);

        local.gridx=0;
        local.gridy=0;
        centro.add(nomeCadastro,local);
        local.gridx=1;
        local.gridy=0;
        centro.add(campoNome,local);
        local.gridx=0;
        local.gridy=1;
        centro.add(precoCadastro,local);
        local.gridx=1;
        local.gridy=1;
        centro.add(campoPreco,local);

        cadastro.add(centro,BorderLayout.CENTER);

        JButton salvar = new JButton("SALVAR");
        JButton cancelar = new JButton("CANCELAR");

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (campoNome.getText().length()>30){
                    JOptionPane.showMessageDialog(null, "Passou de 30 caracteres. ERRO!");
                }else {

                banco.inserir(new Produto(campoNome.getText(),campoPreco.getText()));
                cadastro.dispose();}
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cadastro.dispose();
                return;
            }
        });

        JPanel sul = new JPanel(new BorderLayout());

        sul.add(salvar,BorderLayout.EAST);
        sul.add(cancelar,BorderLayout.WEST);

        cadastro.add(sul,BorderLayout.SOUTH);

        cadastro.setSize(500,200);
        cadastro.setResizable(false);
        cadastro.setModal(true);
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);


    }

    public void TelaEditar(){

        JLabel info = new JLabel("Atualize seu produto");
        JLabel nomeCadastro = new JLabel("Nome do produto :");
        JTextField campoNome = new JTextField(15);
        campoNome.setText(nome.getText());
        JLabel precoCadastro = new JLabel("Preço do produto :");
        JTextField campoPreco = new JTextField(10);
        JPanel centro = new JPanel(new GridBagLayout());
        GridBagConstraints local = new GridBagConstraints();
        JDialog cadastro = new JDialog();

        campoNome.setText(Itens.get(tableL.getSelectedIndex()).getNome());
        campoPreco.setText(Itens.get(tableL.getSelectedIndex()).getPreco());

        cadastro.setLayout(new BorderLayout());
        cadastro.add(info,BorderLayout.NORTH);

        local.gridx=0;
        local.gridy=0;
        centro.add(nomeCadastro,local);
        local.gridx=1;
        local.gridy=0;
        centro.add(campoNome,local);
        local.gridx=0;
        local.gridy=1;
        centro.add(precoCadastro,local);
        local.gridx=1;
        local.gridy=1;
        centro.add(campoPreco,local);

        cadastro.add(centro,BorderLayout.CENTER);

        JButton salvar = new JButton("SALVAR");
        JButton cancelar = new JButton("CANCELAR");

        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (campoNome.getText().length()>30){
                    JOptionPane.showMessageDialog(null, "Passou de 30 caracteres. ERRO!");
                }else {


                    Produto at = Itens.get(tableL.getSelectedIndex());
                at.setNome(campoNome.getText());
                at.setPreco(campoPreco.getText());
                banco.atualizar(at ,at.getID());

                modeloLista.removeAllElements();
                if(Itens.size()!=0){
                    for (Produto Item: Itens) {
                        modeloLista.addElement(Item.produtoToStringNormal());
                    }
                }

                cadastro.dispose();}
            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cadastro.dispose();
                return;
            }
        });

        JPanel sul = new JPanel(new BorderLayout());

        sul.add(salvar,BorderLayout.EAST);
        sul.add(cancelar,BorderLayout.WEST);

        cadastro.add(sul,BorderLayout.SOUTH);

        cadastro.setSize(500,200);
        cadastro.setResizable(false);
        cadastro.setModal(true);
        cadastro.setLocationRelativeTo(null);
        cadastro.setVisible(true);


    }
}