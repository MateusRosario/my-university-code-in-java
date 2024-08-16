package ex3.Server;

import ex3.Estoque;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    Estoque estoque = new Estoque();
    boolean serverOn = true;

    public static void main(String[] args) {
        Server a = new Server();
        a.server();
    }

    private void server(){
        server = startServer();
        assert server != null;
        System.out.println("Server Inicioado no Endereço: " + server.getLocalSocketAddress().toString());

        while (serverOn) {
           try {
               Socket socket = server.accept();
               new Connection(socket, estoque, this).start();

           } catch ( IOException e ) {
               System.out.println("Connection Start Error: " +  e.getMessage());
           }
        }
    }

    private boolean getServerOn(){
        return true;
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