package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela {
    JButton botaoLimpa;
    JTextField campoTexto;
    JFrame janela;
    public Janela() {
        botaoLimpa = new JButton("Limpa");
        campoTexto = new JTextField(10);
        janela = new JFrame("Exemplo de Listener");
        janela.setSize(300,100);
        JPanel painel = new JPanel();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painel.add (botaoLimpa);
        painel.add (campoTexto);
        janela.getContentPane().add(painel);
        botaoLimpa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");

            }
        });
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        Janela janela = new Janela();
    }
}
