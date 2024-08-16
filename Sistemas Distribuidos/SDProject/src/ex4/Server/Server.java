package ex4.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    boolean serverOn;
    public static void main(String[] args) {
        Server a = new Server();
        a.server();
    }

    private void server(){
        server = startServer();
        assert server != null;
        System.out.println("Server Inicioado no Endereço: " + server.getLocalSocketAddress().toString());

        boolean serverOn = true;
        while (serverOn) {
           try {
               Socket socket = server.accept();
               new Connection(socket, this).start();

           } catch ( IOException e ) {
               System.out.println("Connection Start Error: " +  e.getMessage());
           }
           serverOn = this.serverOn;
        }
    }

    private ServerSocket startServer(){
        try{
            return new ServerSocket(4321, 300);
        }catch ( IOException e ){
            e.printStackTrace();
            return null;
        }
    }

    public void shutDown () {
        try{
            this.serverOn = false;
            server.close();
            System.out.println("Server was Finalized by a Client Command");
        }catch ( IOException e ){
            e.printStackTrace();
        }
    }
}