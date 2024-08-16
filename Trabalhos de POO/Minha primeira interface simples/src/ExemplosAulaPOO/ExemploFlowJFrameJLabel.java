package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameJLabel extends JFrame {
    public ExemploFlowJFrameJLabel() {
        setLayout(new FlowLayout());
        add(new JLabel("Java"));
        add(new JLabel("Para"));
        add(new JLabel("Melhor Turma da UFT"));
    }

    public static void main(String[] args) {
        ExemploFlowJFrameJLabel myFrame = new ExemploFlowJFrameJLabel();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
