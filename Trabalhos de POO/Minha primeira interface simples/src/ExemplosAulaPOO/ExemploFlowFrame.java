package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowFrame extends JFrame {
    public ExemploFlowFrame(){
        setLayout(new FlowLayout());
        add(new JButton("B1"));
        add(new JButton("B2"));
        add(new JButton("B3"));
    }

    public static void main(String[] args){
        ExemploFlowFrame myFrame = new ExemploFlowFrame();
        myFrame.setSize(300, 200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
