package CalculaPropriedades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameCalculaPropriedades extends JFrame {
    public JFrameCalculaPropriedades(){
        setTitle("Calcula Propriedades");
        setLayout(new BorderLayout());

        JPanel oeste = new JPanel(new GridLayout(1,1));
        JPanel centro = new JPanel(new FlowLayout());
        JPanel inferior = new JPanel(new FlowLayout());

        JLabel texto = new JLabel("  Texto:");
        oeste.add(texto);

        JTextArea areaTexto = new JTextArea(17,28);
        centro.add(areaTexto);

        JButton botao = new JButton("Calcula");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] mensagens= new String[3];
                mensagens=mensagem(areaTexto.getText());
                JOptionPane.showMessageDialog(null,mensagens[0] + "\n" + mensagens[1] + "\n" + mensagens[2]);
            }
        });
        inferior.add(botao);

        add(oeste, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);
    }

    public String[] mensagem(String texto){
        String[] mensagem = new String[3];
        int palavras=0;
        int linhas=0;
        mensagem[0]=String.format("Caracteres: %d",texto.length());

        for(int i=0; i<texto.length(); i++){
            if(texto.charAt(i)==' ' || texto.charAt(i)==',' || texto.charAt(i)=='.'){
                palavras++;
            }
            if(texto.charAt(i)=='\n'){
                if(texto.charAt(i>0?i-1:i)!='.' && texto.charAt(i>0?i-1:i)!=',' && texto.charAt(i>0?i-1:i)!=' ') {
                    palavras++;
                }
                linhas++;
            }
        }
        if(texto.length()!=0){
            linhas++;
            if(texto.charAt(texto.length()-1)!=' '){
                palavras++;
            }
        }

        mensagem[1]=String.format("Palavras: %d",palavras);
        mensagem[2]=String.format("Linhas: %d",linhas);

        return mensagem;
    }

    public static void main(String[] args) {
        JFrameCalculaPropriedades myframe = new JFrameCalculaPropriedades();
        myframe.setSize(400,350);
        myframe.setLocationRelativeTo(null);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
