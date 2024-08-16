package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameRadioButton extends JFrame {
    public ExemploFlowJFrameRadioButton () {
        setLayout(new FlowLayout());
        add(new JRadioButton("Eu sou um RadioButton"));
    }

    public static void main(String[] args) {
        ExemploFlowJFrameRadioButton myFrame = new ExemploFlowJFrameRadioButton();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
