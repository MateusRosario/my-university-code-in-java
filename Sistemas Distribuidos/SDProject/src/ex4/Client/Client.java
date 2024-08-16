package ex4.Client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket;
        InetSocketAddress serverAdress = new InetSocketAddress("localhost", 4321);
        DataOutputStream send;
        DataInputStream receive;
        Scanner input = new Scanner(System.in);

        String Classpath = Client.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String caminho = Classpath;
        try {
            socket = new Socket();
            socket.connect(serverAdress, 1000);

            send = new DataOutputStream(socket.getOutputStream());
            receive = new DataInputStream(socket.getInputStream());

            System.out.println("Digite nome do Arquivo: ");
            String fileName = input.nextLine();
            send.writeUTF(fileName);

            boolean fileExists = receive.readBoolean();

            if (fileExists) {
                String remoteFileName = receive.readUTF();
                String fileLength = receive.readUTF();
                System.out.println("File Size received");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                FileOutputStream fos = new FileOutputStream(caminho + fileName);
                byte[] buf = new byte[4096];
                while (true) {
                    int len = in.read(buf);
                    if (len == -1)
                        break;

                    fos.write(buf, 0, len);
                }

                fos.flush();
                fos.close();


            }else{
                System.out.println("File does not exist on remote directories");
            }

            String msg = receive.readUTF();
            System.out.println(msg);

            socket.close();
        }catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}