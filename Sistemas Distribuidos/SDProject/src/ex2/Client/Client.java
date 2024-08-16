package ex2.Client;

import ex2.Quadrilatero;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket;
        InetSocketAddress serverAdress = new InetSocketAddress("localhost", 4321);
        ObjectInputStream receive;
        ObjectOutputStream send;
        Scanner input = new Scanner(System.in);


        try {
            socket = new Socket();
            socket.connect(serverAdress, 1000);

            Quadrilatero quadrilatero = new Quadrilatero();
            quadrilatero.leDados();
            send = new ObjectOutputStream(socket.getOutputStream());

            send.writeObject(quadrilatero);
            System.out.println("Quadrilatero Enviado para o servidor\n...");

            System.out.println("Recebendo Quadrilatero do Servidor\n...");
            receive = new ObjectInputStream(socket.getInputStream());
            quadrilatero = (Quadrilatero) receive.readObject();

            quadrilatero.mostraDados();

            socket.close();
        }catch (IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
    }
}