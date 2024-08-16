package ex2.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;

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
               new Connection(socket).start();

           } catch ( IOException e ) {
               System.out.println("Connection Start Error: " +  e.getMessage());
           }
           serverOn = getServerOn();
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
}