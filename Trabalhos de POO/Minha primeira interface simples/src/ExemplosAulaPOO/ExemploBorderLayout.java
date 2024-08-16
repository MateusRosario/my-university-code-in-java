package ExemplosAulaPOO;

import java.awt.*;
import javax.swing.*;

public class ExemploBorderLayout extends JFrame{

    public ExemploBorderLayout(){
        setLayout(new BorderLayout());
        add(new JButton("N"), BorderLayout.NORTH);
        add(new JButton("S"), BorderLayout.SOUTH);
        add(new JButton("E"), BorderLayout.EAST);
        add(new JButton("W"), BorderLayout.WEST);
        add(new JButton("C"), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        ExemploBorderLayout myFrame = new ExemploBorderLayout();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
    }
}
