package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameJTextArea extends JFrame {
    public ExemploFlowJFrameJTextArea() {
        setLayout(new FlowLayout());
        add(new JTextArea(" Eu sou um TextArea! "));
    }

    public static void main(String[] args){
        ExemploFlowJFrameJTextArea myFrame = new ExemploFlowJFrameJTextArea();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
