package basicTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;
        DataOutputStream outputStream;

        try {
            server = new ServerSocket(4321, 300);
            System.out.println(server.getLocalSocketAddress().toString());
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        while ( true ) {
            try {
                assert server != null;
                socket = server.accept();
                outputStream = new DataOutputStream(socket.getOutputStream());

                outputStream.writeUTF("Conectado ...");

                outputStream.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
