package ex2.Server;

import ex2.Quadrilatero;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection extends Thread {
    Socket socket;

    Connection(Socket socket) {
        super();
        this.socket = socket;
        System.out.println("Connecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Aceita.");
    }

    public void run() {
        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Iniciada.");

        Quadrilatero quadrilatero;

        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            quadrilatero = (Quadrilatero) inputStream.readObject();
            System.out.println("Quadrilatero Recebido do Cliente...");

            quadrilatero.indicaTipoDeQuadrilatero();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(quadrilatero);
            System.out.println("Quadrilatero Devolvido para o Cliente...");

            this.socket.close();
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }


        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " finalizada.");
    }
}
