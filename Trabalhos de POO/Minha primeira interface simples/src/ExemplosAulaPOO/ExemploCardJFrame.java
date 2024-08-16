package ExemplosAulaPOO;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ExemploCardJFrame extends JFrame{
    private CardLayout myCL = new CardLayout();
    private Container myPane = getContentPane();
    public ExemploCardJFrame() {
        JButton b1 = new JButton("Primeiro Botao");
        JButton b2 = new JButton("Segundo botao");
        JButton b3 = new JButton("Terceiro Botao");
        setLayout(myCL);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(new Btn());
        b2.addActionListener(new Btn());
        b3.addActionListener(new Btn());
    }

    class Btn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            myCL.next(myPane);
        }
    }

    public static void main(String[] args) {
        ExemploCardJFrame myFrame = new ExemploCardJFrame();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
    }
}
