package ex3.Server;

import ex3.Estoque;
import ex3.Produto;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Connection extends Thread {
    Socket socket;
    Estoque estoque;
    Server server;

    Connection(Socket socket, Estoque estoque, Server server) {
        super();
        this.socket = socket;
        this.estoque = estoque;
        this.server = server;
        System.out.println("Connecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Aceita.");
    }

    public void run() {
        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " Iniciada.");

        Produto produto;

        try{

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            while (socket.isConnected()) {
                System.out.println("Esperando novas entradas\n...");
                produto = (Produto) inputStream.readObject();
                System.out.println("Entrada recebida do Cliente.");

                if (produto.getNome().toLowerCase().equals("terminar")) {
                    this.server.shutDown();
                    outputStream.writeUTF("Servidor Finalizado");
                    return;
                }

                String resposta = this.estoque.entrada(produto);

                outputStream.writeUTF(resposta);
                System.out.println("Resposta Enviada ao Cliente.");

            }
            this.socket.close();
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }


        System.out.println("Conecção com " + this.socket.getInetAddress() + ':' + this.socket.getPort() + " finalizada.");
    }
}
