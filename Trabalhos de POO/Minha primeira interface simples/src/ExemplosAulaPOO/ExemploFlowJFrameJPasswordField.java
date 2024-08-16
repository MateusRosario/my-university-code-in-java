package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameJPasswordField extends JFrame{
    JPasswordField myPassword;

    public ExemploFlowJFrameJPasswordField(){
        setLayout(new FlowLayout());
        myPassword = new JPasswordField(16);
        add(myPassword);
    }

    public static void main(String[] args){
        ExemploFlowJFrameJPasswordField myFrame = new ExemploFlowJFrameJPasswordField();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}