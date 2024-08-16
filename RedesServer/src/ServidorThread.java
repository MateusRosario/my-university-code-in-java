import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
public class ServidorThread extends Thread {

    public Socket s1;
    String cadena = " ", msg=" ";
    int num;
    DataOutputStream s1out;
    DataInputStream s1In;
    ArrayList<Integer> numeros = new ArrayList<Integer>();

    public ServidorThread(Socket s1) {
        super();
        this.s1 = s1;
    }

    @Override
    public void run() {

        try {
            s1out = new DataOutputStream(s1.getOutputStream());
            s1In = new DataInputStream(s1.getInputStream());
            do {

                for(int i=0; i<3;i++){
                    num=s1In.readInt();
                    numeros.add(num);
                    if(numeros.get(0)<0){
                        break;
                    }
                }
                if(numeros.get(0)<0){
                    s1out.writeUTF("Servidor: Conexão encerrada");
                    s1.close();
                    break;
                }
                //s1out.writeUTF(cadena);
                Collections.sort(numeros);
                s1out.writeUTF("O menor valor é: "+numeros.get(0)+" O maior valor é: "+numeros.get(2));
                //s1out.writeUTF("O maior valor é: "+numeros.get(2));
                numeros.clear();
            }while(true);
        }catch( IOException e ) {
            System.out.println( e );
        }
    }
}
