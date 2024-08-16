package ex3.Client;

import ex2.Quadrilatero;
import ex3.Produto;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        InetSocketAddress serverAdress = new InetSocketAddress("localhost", 4321);
        DataInputStream receive;
        ObjectOutputStream send;
        Scanner input = new Scanner(System.in);

        try {
            socket = new Socket();
            socket.connect(serverAdress, 1000);

            send = new ObjectOutputStream(socket.getOutputStream());

            receive = new DataInputStream(socket.getInputStream());

            String continuar = "s";
            while (continuar.charAt(0) == 's') {
                Produto novaEntrada = new Produto();
                System.out.println("Digite o nome da nova Entrada: ");
                novaEntrada.setNome(input.nextLine());

                System.out.println("Digite a quantidade: ");
                novaEntrada.setQty(input.nextInt());
                input.nextLine();

                send.writeObject(novaEntrada);
                System.out.println("Entrada enviada para o Servidor");
                System.out.println("Aguardando Reposta\n...");

                String resposta = receive.readUTF();

                System.out.println("Resposta do Server: " + resposta);

                if (resposta.equals("Servidor Finalizado")){
                    System.out.println("Conexão Perdida, Fechando Cliente\n...");
                    return;
                }

                do {
                    System.out.println("Deseja adicionar outra entrada? s | n");
                    continuar = input.nextLine();
                } while (continuar.length() == 0 || (continuar.charAt(0) != 's' && continuar.charAt(0) != 'n'));
            }

            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}