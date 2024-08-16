import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    static Scanner input = new Scanner(System.in);
    static String user = "";

    public static void main(String[] args) throws IOException {
        System.out.println("Bem Vindo a este não nomeado Prototipo de Chat.\n");
        boolean conectado = false;
        Socket conexao = null;

        do {
            String ip;
            do {
                System.out.println("Digite o IP do Servidor que deseja Conectar:");
                System.out.print(">>");
                ip = input.nextLine();
            } while (ip.equals("") || !ip.contains(":"));
            String porta = ip.split(";")[1];
            ip = ip.split(";")[0];

            try {
                conexao = new Socket(ip, Integer.parseInt(porta));

                System.out.println("Parece que o Servidor Está Online.");
                if (conexao.isConnected()) {
                    //imprime o endereço de IP do servidor
                    System.out.println("Pronto: Você esta Conectado ao servidor");
                    conectado = true;
                }


            } catch (ConnectException c) {
                System.out.println(" Desculpe, mas parece que este servidor esta Offline.\n Tente mais tarde, ou se conecte a outro servidor.\n");
                System.out.println("(1)Conectar a outro IP");
                System.out.print("(2)Sair\n>>");
                String op;
                op = input.nextLine();
                if(op.equals("2")){
                    return;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }while (!conectado);

        System.out.println("Vamos tentar Entrar no Chat");
        logar(conexao);
        barradetexto(conexao);
        chat(conexao);
    }

    public static void logar(Socket conexao)throws IOException{
        while (true) {
            do {
                System.out.println("Escolha um nome de Usuario:");
                user = input.next();
            } while (user.equals(""));

            String requisicao = "Entrar " + user + "\n";
            OutputStream envio = conexao.getOutputStream();
            byte[] b = requisicao.getBytes();
            envio.write(b);
            envio.flush();

            Scanner servInput = new Scanner(conexao.getInputStream());
            String[] resposta = servInput.nextLine().split(" ");
            if (resposta[1].equals("Aceito")) {
                System.out.println("Você entrou no Chat como " + resposta[2]);
                return;
            } else {
                System.out.println("Sua entrada foi Negada pois Usuario " + user + " já existe no chat");
                System.out.println("Tente com outro nome");
            }
        }
    }

    public static void chat(Socket conexao){
        System.out.println("+++++++++++++++++++++++++++Conversa+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n");
        while (true){
            try {
                System.out.println("\n\n");
                Scanner servInput = new Scanner(conexao.getInputStream());
                while (servInput.hasNext()) {
                    System.out.println(servInput.nextLine());
                }
                System.out.println("\n\n");
            }catch (IOException io){
                System.out.println(io);
            }
        }
    }

    public static void barradetexto(Socket conexao) throws IOException{
        JFrame janela = new JFrame();
        janela.setSize(400, 120);
        janela.setLayout(new BorderLayout());

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        JTextArea texto = new JTextArea();
        center.add(texto);

        JPanel bottom = new JPanel();
        JButton enviar = new JButton("Enviar");

        OutputStream envioServ = conexao.getOutputStream();

        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String mens = texto.getText();
                System.out.println("EU: \n" + mens + "\n");
                mens = "Mandar " + "user\n" + mens + "\n\n";
                try {
                    envioServ.write(mens.getBytes());
                    envioServ.flush();

                }catch (IOException io){
                    System.out.println("Não foi possivel Mandar a mensagem: " + io);
                }
                texto.setText("");
            }
        });

        bottom.add(enviar);
        janela.setTitle(user);
        janela.add(center, BorderLayout.CENTER);
        janela.add(bottom, BorderLayout.SOUTH);
        janela.setVisible(true);
    }
}
