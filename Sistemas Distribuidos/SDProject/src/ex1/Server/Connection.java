package ex1.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Connection extends Thread {
    Socket socket;
    Server server;

    Connection(Socket socket, Server server) {
        super();
        this.server = server;
        this.socket = socket;
        System.out.println("Connecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Aceita.");
    }

    public void run() {
        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Iniciada.");

        int a;
        int b;
        int c;

        try{
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            a = inputStream.readInt();

            if(a < 0){
                System.out.println("Server shutdown called\nConnection Finalized");
                this.socket.close();
                this.server.shutDown();
                return;
            }

            b = inputStream.readInt();
            c = inputStream.readInt();
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Maior valor é " + bigger(a, b, c) + " e menor valor é " + smaller(a, b, c) + ".");

            this.socket.close();
        }catch(Exception e){

            System.out.println("Error" + e.getMessage());

        }


        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " finalizada.");
    }

    private int smaller(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private int bigger(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

}
