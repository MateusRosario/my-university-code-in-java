package ExemplosAulaPOO;

import javax.swing.*;
import java.awt.*;

public class ExemploLayoutClass  extends JFrame {
    public ExemploLayoutClass() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        for(int i=1 ; i < 10 ; i++ ){
            add(new JButton("MyButton" + i));
        }
    }

    public static void main(String[] args){
        ExemploLayoutClass myFrame = new ExemploLayoutClass();
        myFrame.setSize(400,300);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
