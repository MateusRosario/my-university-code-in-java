package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploFlowFrameJCheckBox extends JFrame {
    public ExemploFlowFrameJCheckBox() {
        setLayout(new FlowLayout());
        add(new JCheckBox("Eu sou um CheckBox"));
    }

    public static void main(String[] args) {
        ExemploFlowFrameJCheckBox myFrame = new ExemploFlowFrameJCheckBox();
        myFrame.setSize(300, 200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
