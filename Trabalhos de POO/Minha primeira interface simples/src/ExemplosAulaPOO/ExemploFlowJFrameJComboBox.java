package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowJFrameJComboBox extends JFrame{
    public ExemploFlowJFrameJComboBox() {
        setLayout(new FlowLayout());
        JComboBox color = new JComboBox();
        color.addItem("Vermelho");
        color.addItem("Amarelo");
        color.addItem("Cinza");
        add(color);//add "color" object to frame.
    }
    public static void main(String[] args) {
        ExemploFlowJFrameJComboBox myFrame = new ExemploFlowJFrameJComboBox();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
