package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaMain extends JFrame {

    CardLayout pagina;
    JPanel janela;
    Main main;
    //========================================
    JPanel painelMain;
    Tela painelAcesso;
    JPanel centerPainel;
    DefaultListModel modeloJlist = new DefaultListModel();

    JList<String> listBancos;
    JPanel bottonPainel;
    JButton criarBD;
    JButton excluirBD;
    JButton acessarBD;

    String string;

    public TelaMain(int Largura, int Altura, Main main){
        this.main = main;
        setTitle("Gerenciador de Banco De Dados");
        setSize(Largura, Altura);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        janela = new JPanel();
        pagina = new CardLayout();
        janela.setLayout(pagina);
        painelMain = new JPanel();
        elementosPainelMain();
        painelAcesso = new Tela(this);
        janela.add(painelMain, "Main");
        janela.add(painelAcesso, "acessoBD");
        pagina.show(janela, "Main");
        add(janela, BorderLayout.CENTER);
        setVisible(true);
    }

    public void elementosPainelMain(){
        painelMain.setLayout(new BorderLayout());
        centerPainel = new JPanel();
        elementosCenterPainel();
        bottonPainel = new JPanel();
        elementosBottonPainel();
        painelMain.add(centerPainel, BorderLayout.CENTER);
        painelMain.add(bottonPainel, BorderLayout.SOUTH);
    }

    public void elementosCenterPainel(){
        centerPainel.setLayout(new BorderLayout());
        setJList(main.getBancosArray());
        listBancos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerPainel.add(new JScrollPane(listBancos), BorderLayout.CENTER);
    }

    public void elementosBottonPainel(){
        bottonPainel.setLayout(new BorderLayout());
        criarBD = new JButton("Criar novo BD");
        excluirBD = new JButton("Excluir BD");
        acessarBD = new JButton("Acessar BD");
        bottonPainel.add(criarBD, BorderLayout.WEST);
        bottonPainel.add(excluirBD, BorderLayout.CENTER);
        bottonPainel.add(acessarBD, BorderLayout.EAST);

        atividadesPainelBotton();
    }

    public void atividadesPainelBotton(){
        criarBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog criarBD = new JDialog(new Frame(), "Criar BD");
                String nome = elementosCriarBDDialog(criarBD);
                if(nome != null && !nome.equals("")){
                    main.criarBD(nome);
                    modeloJlist.addElement(nome);
                }
            }
        });

        excluirBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int a = listBancos.getSelectedIndex();
                main.excluirBD((String) modeloJlist.get(a));
                modeloJlist.remove(a);
            }
        });

        acessarBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                painelAcesso.setSelecionado(main.getSelecionado((String) modeloJlist.get(listBancos.getSelectedIndex())));
                pagina.show(janela, "acessoBD");
            }
        });
    }

    public String elementosCriarBDDialog(JDialog criar){
        JPanel painel = new JPanel(new BorderLayout());
        //===============================================Elementos do Centro do Painel de Dialogo ======;
        JPanel centro = new JPanel(new FlowLayout());
        JLabel textoL = new JLabel("Nome: ");
        JTextField texto = new JTextField(20);
        texto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
                    string = texto.getText();
                    criar.dispose();
                }
            }
        });
        centro.add(textoL);
        centro.add(texto);
        painel.add(centro, BorderLayout.CENTER);
        //============================================== Elementos de Baixo do Painel de Dialogo ======;
        JPanel baixo = new JPanel(new BorderLayout());
        JButton okB = new JButton("Confirmar");

        baixo.add(okB, BorderLayout.CENTER);
        painel.add(baixo, BorderLayout.SOUTH);
        //=======================================================

        okB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                string = texto.getText();
                criar.dispose();
            }
        });

        criar.setContentPane(painel);
        criar.setSize(320,100);
        criar.setResizable(false);
        criar.setModal(true);
        criar.setLocationRelativeTo(null);
        criar.setVisible(true);
        return string;
    }

    public void setJList(String[] array){
        for (String item: array) {
            modeloJlist.addElement(item);
        }
        listBancos = new JList<String>(modeloJlist);
    }

    public void voltarMain(){
        pagina.show(janela, "Main");
    }
}
