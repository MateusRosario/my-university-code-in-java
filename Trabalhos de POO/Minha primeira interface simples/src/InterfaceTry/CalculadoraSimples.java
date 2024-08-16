package InterfaceTry;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalculadoraSimples {
    private Double var=0.0;
    private Double var2=0.0;
    private int action=0;
    private char operacao;
    private String stringAtual="";
    private JButton ce;
    private JButton plus;
    private JButton minus;
    private JButton times;
    private JButton divid;
    private JButton equals;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonP;
    private JButton buttonBack;
    private JLabel visor;


    public CalculadoraSimples(){
        ce= new JButton("CE");
        plus= new JButton("+");
        minus= new JButton("-");
        times= new JButton("x");
        divid= new JButton("/");
        equals= new JButton("=");
        button1= new JButton("1");
        button2= new JButton("2");
        button3= new JButton("3");
        button4= new JButton("4");
        button5= new JButton("5");
        button6= new JButton("6");
        button7= new JButton("7");
        button8= new JButton("8");
        button9= new JButton("9");
        button0= new JButton("0");
        buttonP= new JButton(".");
        buttonBack=new JButton("<-");
        visor = new JLabel();
        JFrame janela = new JFrame("Calculadora Simples");
        janela.setSize(400,400);

        JPanel Visor =new JPanel(new GridLayout(2,1));
        JPanel painel = new JPanel(new GridLayout(6,3));
        Visor.add(visor);

        Font fonte =new Font("SansSerif",Font.BOLD,30);

        ce.setBackground(Color.GRAY);
        plus.setBackground(Color.GRAY);
        minus.setBackground(Color.GRAY);
        times.setBackground(Color.GRAY);
        divid.setBackground(Color.GRAY);
        equals.setBackground(Color.GRAY);
        button1.setBackground(Color.LIGHT_GRAY);
        button2.setBackground(Color.LIGHT_GRAY);
        button3.setBackground(Color.LIGHT_GRAY);
        button4.setBackground(Color.LIGHT_GRAY);
        button5.setBackground(Color.LIGHT_GRAY);
        button6.setBackground(Color.LIGHT_GRAY);
        button7.setBackground(Color.LIGHT_GRAY);
        button8.setBackground(Color.LIGHT_GRAY);
        button9.setBackground(Color.LIGHT_GRAY);
        button0.setBackground(Color.LIGHT_GRAY);
        buttonP.setBackground(Color.LIGHT_GRAY);
        buttonBack.setBackground(Color.LIGHT_GRAY);

        visor.setFont(fonte);
        ce.setFont(fonte);
        plus.setFont(fonte);
        minus.setFont(fonte);
        times.setFont(fonte);
        divid.setFont(fonte);
        equals.setFont(fonte);
        button1.setFont(fonte);
        button2.setFont(fonte);
        button3.setFont(fonte);
        button4.setFont(fonte);
        button5.setFont(fonte);
        button6.setFont(fonte);
        button7.setFont(fonte);
        button8.setFont(fonte);
        button9.setFont(fonte);
        button0.setFont(fonte);
        buttonP.setFont(fonte);
        buttonBack.setFont(fonte);

        visor.setText(" ");

        painel.add(button7);
        painel.add(button8);
        painel.add(button9);
        painel.add(button4);
        painel.add(button5);
        painel.add(button6);
        painel.add(button1);
        painel.add(button2);
        painel.add(button3);
        painel.add(buttonP);
        painel.add(button0);
        painel.add(buttonBack);
        painel.add(ce);
        painel.add(plus);
        painel.add(minus);
        painel.add(times);
        painel.add(divid);

        painel.add(equals);


        janela.setLayout(new BorderLayout());

        janela.getContentPane().add(Visor, BorderLayout.NORTH);
        janela.getContentPane().add(painel, BorderLayout.CENTER);

        calc();

        janela.setVisible(true);
    }

    private void calc(){

        ce.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                visor.setText(" ");
                stringAtual="";
                action=0;
                var=0.0;
                var2=0.0;
            }
        });

        plus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                operar('+');
            }
        });

        minus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                operar('-');
            }
        });

        times.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                operar('x');
            }
        });

        divid.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                operar('/');
            }
        });

        equals.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                result();
                action=0;
            }
        });

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "1";
                visor.setText(stringAtual);
            }
        });

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "2";
                visor.setText(stringAtual);
            }
        });

        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "3";
                visor.setText(stringAtual);
            }
        });

        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "4";
                visor.setText(stringAtual);
            }
        });

        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "5";
                visor.setText(stringAtual);
            }
        });

        button6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "6";
                visor.setText(stringAtual);
            }
        });

        button7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "7";
                visor.setText(stringAtual);
            }
        });

        button8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "8";
                visor.setText(stringAtual);
            }
        });

        button9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "9";
                visor.setText(stringAtual);
            }
        });

        button0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + "0";
                visor.setText(stringAtual);
            }
        });

        buttonP.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                stringAtual=stringAtual + ".";
                visor.setText(stringAtual);
            }
        });

        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String temp;
                boolean setaction=true;
                temp=stringAtual;
                stringAtual="";
                for(int i=0;i<temp.length()-1;i++){
                    stringAtual=stringAtual + temp.charAt(i);
                    if(temp.charAt(i)=='+' || temp.charAt(i)=='-' || temp.charAt(i)=='X' || temp.charAt(i)=='/'){
                        setaction=false;
                    }
                }
                if(setaction){
                    action=0;
                }
                visor.setText(" " + stringAtual);
            }
        });

    }

    private void result(){
        if(action==0){
            visor.setText(" " + stringAtual);
        }else {
            Double result;
            String recebe;
            recebe = separarString(stringAtual, operacao);
            var2 = Double.parseDouble(recebe);
            result = calcular();
            stringAtual = " " + result;
            visor.setText(stringAtual);
            var2 = 0.0;
            var = result;
        }
    }

    private void operar(char operacao){
            result();
            this.operacao = operacao;
            var = Double.parseDouble(stringAtual);
            stringAtual = " " + stringAtual + operacao;
            visor.setText(stringAtual);
            action++;
    }

    private Double calcular(){
        switch (this.operacao){
            case '+':
                    return var+var2;
            case '-':
                    return var-var2;
            case '/':
                    return var/var2;
            case 'x':
                    return var*var2;
        }
        return 0.0;
    }

    private String separarString(String a,char token){
        String b="";
        boolean tokenFound=false;
        for(int i=0;i<a.length();i++){
            if(tokenFound){
                b=b + a.charAt(i);
            }else{
                if(a.charAt(i)==token){
                    tokenFound=true;
                }
            }
        }
        return b;
    }
}
