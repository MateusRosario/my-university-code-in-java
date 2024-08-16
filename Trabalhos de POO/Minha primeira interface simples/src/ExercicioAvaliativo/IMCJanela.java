package ExercicioAvaliativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCJanela extends JFrame {
    private JLabel digPeso;
    private JLabel digAltura;
    private JLabel valorIMC;
    private JLabel resuIMC;
    private JLabel categoria;
    private JLabel textCateg;
    private JComboBox sexo;
    private JTextField peso;
    private JTextField altura;
    private JButton calc;
    private JLabel vazio;
    private JLabel vazio1;
    private double Peso;
    private double Altura;
    private double IMC;
    private String Sexo;

    public IMCJanela() {
        setLayout(new GridBagLayout());
        estancias();
        actions();
    }

    public void actions() {
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Altura = Double.parseDouble(altura.getText().replaceAll(",","."));
                Peso = Double.parseDouble(peso.getText().replaceAll(",","."));
                IMC = Peso/(Altura*Altura);
                resuIMC.setText(String.format("%.3f",IMC));
                Sexo = (String) sexo.getSelectedItem();
                if(Sexo=="Masculino"){
                    if(IMC<20.7){
                        categoria.setText(" Abaixo do Peso");
                    }else if(IMC<=26.4){
                        categoria.setText(" Peso Ideal");
                    }else if(IMC<=27.8){
                        categoria.setText(" Pouco acima do Peso");
                    }else if(IMC<=31.1){
                        categoria.setText(" Acima do Peso");
                    }else{
                        categoria.setText(" Obesidade");
                    }
                }else if(Sexo=="Feminino"){
                    if(IMC<19.1){
                        categoria.setText(" Abaixo do Peso");
                    }else if(IMC<=25.8){
                        categoria.setText(" Peso Ideal");
                    }else if(IMC<=27.3){
                        categoria.setText(" Pouco acima do Peso");
                    }else if(IMC<=32.3){
                        categoria.setText(" Acima do Peso");
                    }else{
                        categoria.setText(" Obesidade");
                    }
                }
            }
        });
    }

    public void estancias() {
        GridBagConstraints place = new GridBagConstraints();
        digPeso = new JLabel("Digite seu Peso (Kg):");
        place.gridx = 0;
        place.gridy = 0;
        add(digPeso, place);
        peso = new JTextField(10);
        place.gridx = 1;
        place.gridy = 0;
        add(peso, place);
        digAltura = new JLabel(" Digite sua Altura (cm):");
        place.gridx = 0;
        place.gridy = 1;
        add(digAltura, place);
        altura = new JTextField(10);
        place.gridx = 1;
        place.gridy = 1;
        add(altura, place);
        valorIMC = new JLabel("     Valor do IMC:");
        place.gridx = 2;
        place.gridy = 0;
        add(valorIMC, place);
        resuIMC = new JLabel(" ");
        place.gridx = 3;
        place.gridy = 0;
        add(resuIMC, place);
        textCateg = new JLabel("      Sua categoria:");
        place.gridx = 2;
        place.gridy = 1;
        add(textCateg, place);
        categoria = new JLabel(" ");
        place.gridx = 3;
        place.gridy = 1;
        add(categoria, place);
        sexo = new JComboBox();
        sexo.addItem("Masculino");
        sexo.addItem("Feminino");
        place.gridx = 0;
        place.gridy = 3;
        add(sexo, place);
        calc = new JButton("Calcular");
        place.gridx = 2;
        place.gridy = 3;
        add(calc, place);
        vazio = new JLabel("    ");
        place.gridx = 0;
        place.gridy = 2;
        add(vazio, place);
    }

    public static void main(String[] args) {
        IMCJanela myFrame = new IMCJanela();
        myFrame.setSize(550,200);
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
