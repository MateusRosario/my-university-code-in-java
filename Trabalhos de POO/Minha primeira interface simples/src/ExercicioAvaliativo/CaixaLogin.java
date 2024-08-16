package ExercicioAvaliativo;

import ExemplosAulaPOO.Janela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaixaLogin extends JFrame {
    JTextField login;
    JPasswordField senha;
    JButton confirma;
    public CaixaLogin () {
        setLayout(new FlowLayout());
        JLabel textLogin = new JLabel("Login:");
        JLabel textSenha = new JLabel("Senha:");
        login = new JTextField(16);
        senha = new JPasswordField(16);
        confirma = new JButton("Comfirmar");
        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Login efetuado com sucesso");
                login.setText("");
                senha.setText("");
            }
        });
        add(textLogin);
        add(login);
        add(textSenha);
        add(senha);
        add(confirma);

    }

    public static void main(String[] args) {
        CaixaLogin myframe = new CaixaLogin();
        myframe.setSize(300,125);
        myframe.setVisible(true);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}