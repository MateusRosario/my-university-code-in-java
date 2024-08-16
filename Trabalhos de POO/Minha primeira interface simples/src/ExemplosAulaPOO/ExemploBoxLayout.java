package ExemplosAulaPOO;

import java.awt.*;
import javax.swing.*;

public class ExemploBoxLayout {
    private JFrame frame;
    private JPanel vPanel;
    public static void main(String[] args){
        ExemploBoxLayout myEg = new ExemploBoxLayout();
        myEg.BoxLayoutDemo();
    }

    private void BoxLayoutDemo() {
        frame = new JFrame();
        Container contentPane = frame.getContentPane();

        vPanel = new JPanel();
        vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.Y_AXIS));
        vPanel.add(new Label("Number 1"));
        vPanel.add(new Label("Number 2"));
        vPanel.add(new Label("Number 3"));
        vPanel.add(new Label("Number 4"));
        vPanel.add(new Label("Number 5"));
        contentPane.add(vPanel);
        frame.pack();
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}