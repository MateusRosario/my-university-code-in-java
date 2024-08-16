package ex4.Server;

import ex6.WebCrawler;

import java.io.*;
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
        String Classpath = Connection.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        try{
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String arquivo = inputStream.readUTF();

            System.out.println("File: " + Classpath + arquivo);
            File file = new File(Classpath + arquivo);

            if(file.exists()){
                outputStream.writeBoolean(true);
                outputStream.writeUTF(file.getName());
                outputStream.writeLong(file.length());

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                FileInputStream filein = new FileInputStream(file);
                byte[] buf = new byte[4096];

                while (true) {
                    int len = filein.read(buf);
                    if (len == -1)
                        break;
                    out.write(buf, 0, len);
                }

                out.close();

                outputStream.writeUTF("Arquivo Enviado");
            }else{
                outputStream.writeBoolean(false);
                outputStream.writeUTF("Arquivo Não Enviado");
            }

            this.socket.close();
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }


        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " finalizada.");
    }
}
