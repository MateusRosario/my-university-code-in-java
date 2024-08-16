package ExercicioAvaliativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalarioSelec extends JFrame{
    public SalarioSelec (){
        setLayout(new FlowLayout());
        JRadioButton op1 = new JRadioButton("Até R$ 500,00");
        JRadioButton op2 = new JRadioButton("De R$ 501,00 até R$ 1000,00");
        JRadioButton op3 = new JRadioButton("De R$ 1001,00 até R$ 3000,00");
        JRadioButton op4 = new JRadioButton("Acima de R$ 3000,00");
        ButtonGroup RadioGroup = new ButtonGroup();
        RadioGroup.add(op1);
        RadioGroup.add(op2);
        RadioGroup.add(op3);
        RadioGroup.add(op4);
        JLabel text = new JLabel();


        op1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.setText("Não é o melhor salário de todos.");
            }
        });

        op2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.setText("Dá pra ir levando.");
            }
        });

        op3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.setText("Me parece que vc ta de Boa.");
            }
        });

        op4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                text.setText("Uou, Vc não é Humilde.");
            }
        });

        JPanel painel = new JPanel(new GridLayout(5,1));
        painel.add(op1);
        painel.add(op2);
        painel.add(op3);
        painel.add(op4);
        painel.add(text);
        add(painel);
        setVisible(true);
    }


    public static void main(String[] args) {
        SalarioSelec myFrame = new SalarioSelec();
        myFrame.setSize(300,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
