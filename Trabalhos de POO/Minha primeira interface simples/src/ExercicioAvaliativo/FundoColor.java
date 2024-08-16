package ExercicioAvaliativo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FundoColor extends JFrame{
    String color;
    public FundoColor(){
        setLayout(new FlowLayout());
        DefaultListModel model = new DefaultListModel();
        JList fundo = new JList(model);

        model.add(0,"Black");
        model.add(1, "Blue");
        model.add(2, "Cyan");
        model.add(3, "Dark Gray");
        model.add(4, "Gray");
        model.add(5, "Green");
        model.add(6, "Light Gray");
        model.add(7, "Magenta");
        model.add(8, "Orange");
        model.add(9, "Pink");
        model.add(9, "Red");
        model.add(9, "White");
        model.add(9, "Yellow");

        fundo.setVisibleRowCount(4);


        fundo.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                color=(String) fundo.getSelectedValue();
                switch (color){
                    case "Black":
                        getContentPane().setBackground(Color.BLACK);
                        break;
                    case "Blue":
                        getContentPane().setBackground(Color.BLUE);
                        break;
                    case "Cyan":
                        getContentPane().setBackground(Color.CYAN);
                        break;
                    case "Dark Gray":
                        getContentPane().setBackground(Color.DARK_GRAY);
                        break;
                    case "Gray":
                        getContentPane().setBackground(Color.GRAY);
                        break;
                    case "Green":
                        getContentPane().setBackground(Color.GREEN);
                        break;
                    case "Light Green":
                        getContentPane().setBackground(Color.LIGHT_GRAY);
                        break;
                    case "Magenta":
                        getContentPane().setBackground(Color.MAGENTA);
                        break;
                    case "Orange":
                        getContentPane().setBackground(Color.ORANGE);
                        break;
                    case "Pink":
                        getContentPane().setBackground(Color.PINK);
                        break;
                    case "Red":
                        getContentPane().setBackground(Color.RED);
                        break;
                    case "White":
                        getContentPane().setBackground(Color.WHITE);
                        break;
                    case "Yellow":
                        getContentPane().setBackground(Color.YELLOW);
                        break;
                }

            }
        });
        add(fundo);

    }

    public static void main(String[] args) {
        FundoColor myFrame = new FundoColor();
        myFrame.setSize(200,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
