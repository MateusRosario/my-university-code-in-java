package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploGridBagLayout extends JFrame {
    public ExemploGridBagLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints place = new GridBagConstraints();

        JButton b1 = new JButton("B 1");
        place.gridx = 2;
        place.gridy = 0;
        add(b1, place);
        JButton b2 = new JButton("B 2");
        place.gridx = 0;
        place.gridy = 2;
        add(b2, place);
        JButton b3 = new JButton("B 3");
        place.gridx = 6;
        place.gridy = 0;
        add(b3, place);
        JButton b4 = new JButton("B 4");
        place.gridx = 5;
        place.gridy = 6;
        add(b4, place);
    }

    public static void main(String[] args){
        ExemploGridBagLayout myFrame = new ExemploGridBagLayout();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
