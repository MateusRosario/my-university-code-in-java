package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameJTextField extends JFrame{
    public ExemploFlowJFrameJTextField() {
        setLayout(new FlowLayout());
        add(new JTextField(" Eu sou um TextArea! "));
    }

    public static void main(String[] args){
        ExemploFlowJFrameJTextField myFrame = new ExemploFlowJFrameJTextField();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
