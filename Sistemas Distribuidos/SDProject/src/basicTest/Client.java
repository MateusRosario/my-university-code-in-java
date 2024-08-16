package basicTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket;
        InetSocketAddress serverAdress = new InetSocketAddress("localhost", 4321);
        DataInputStream receive;

        try {
            socket = new Socket();
            socket.connect(serverAdress, 1000);

            receive = new DataInputStream(socket.getInputStream());

            int c;
            while ( (c = receive.read()) != -1 ){
                System.out.println((char)c);
            }

            String msg = receive.readUTF();
            System.out.println(msg);

            socket.close();
        }catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
