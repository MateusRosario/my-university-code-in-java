
import java.awt.event.*;
import javax.swing.*;


public class JanelaSimples {
    static int cont=0;
    public JanelaSimples(){
        final JButton botaoAdiciona = new JButton("Add a unit '++'"); //botão.
        final JButton botaoRemove = new JButton("Remove a unit '--'"); //botão.
        final JTextField campoTexto = new JTextField(10);
        final JFrame janela = new JFrame("Janela Contador");
        janela.setSize(300,200);

        JPanel painel = new JPanel();
        painel.add(botaoAdiciona);
        painel.add(botaoRemove);
        painel.add (campoTexto);
        janela.getContentPane().add(painel);

        campoTexto.setText("Unidades: " + cont);

        botaoAdiciona.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaSimples.cont++;
                campoTexto.setText("Unidades: " + cont);

            }

        });

        botaoRemove.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaSimples.cont--;
                campoTexto.setText("Unidades: " + cont);

            }

        });

         janela.setVisible(true);
    }
}
