import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Servidor {
    public static void main( String args[] ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
        //DataOutputStream enviar;

        try {
            //Criar o ServerSocket, espear a conexão na porta 4321
            s = new ServerSocket(4321);
        }
        catch( IOException e ) {
            //Exceção
            System.out.println( e );
        }

        while(true) {
            try {
                //Criando objeto socket para tratar a conexão com o cliente, assim
                //que o pedido chegar da conexão ao servidor
                s1 = s.accept();
                //Criação do objeto do servidor Thread para execução
                ServidorThread serviceThread = new ServidorThread(s1);
                serviceThread.start();
            }
            catch( IOException e ){
                System.out.println( e );
            }
        }
    }
}