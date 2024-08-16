package ex1.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket;
        InetSocketAddress serverAdress = new InetSocketAddress("localhost", 4321);
        DataInputStream receive;
        DataOutputStream send;
        Scanner input = new Scanner(System.in);


        try {
            socket = new Socket();
            socket.connect(serverAdress, 1000);

            send = new DataOutputStream(socket.getOutputStream());

            System.out.println("Digite Primeiro Número: ");
            int firstInt = input.nextInt();
            send.writeInt(firstInt);

            if (firstInt < 0) {
                System.out.println("Entendido, Sever Finalizado.");
                socket.close();
                System.out.println("Conecção Fechada.");
                return;
            }

            System.out.println("Digite Segundo Número: ");
            send.writeInt(input.nextInt());

            System.out.println("Digite Terceiro Número: ");
            send.writeInt(input.nextInt());

            receive = new DataInputStream(socket.getInputStream());

            String msg = receive.readUTF();
            System.out.println(msg);

            socket.close();
        }catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}