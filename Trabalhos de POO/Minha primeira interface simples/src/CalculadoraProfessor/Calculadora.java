package CalculadoraProfessor;

import java.awt.*;
import javax.swing.*;

public class Calculadora {
    public static void main(String[] args){
        JFrame janela = new JFrame("Celular");
        JLabel visor = new JLabel("5122299");
        visor.setAlignmentX(JLabel.RIGHT);
        JPanel num = new JPanel(new GridLayout(4 , 3));
        String[] n = {"1","2","3","4","5","6","7","8","9","*","0","#"};
        for(int i=0;i<n.length; i++){ num.add(new Button(n[i])); }
        JPanel botoes = new JPanel();
        //((FlowLayout)botoes.getLayout().setVgap(0);
        botoes.add(new Button("send"));
        botoes.add(new Button("end"));
        janela.add(visor, BorderLayout.NORTH);
        janela.add(num, BorderLayout.CENTER);
        janela.add(botoes, BorderLayout.SOUTH);
        janela.pack();
        janela.setVisible(true);

    }
}
