import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

    public static void main(String[] args) throws IOException{
        Random aleatorio = new Random();
        int porta = (aleatorio.nextInt(9999-1234)) + 1234;
        ServerSocket servidor = new ServerSocket(porta);
        String ip = getIP();
        printIP();
        System.out.println("Servidor Executando com IPv6: " + ip + ";" + porta);
        Chat chat = new Chat();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        while (true){
            pool.execute(new ConexaoCliente(servidor.accept(), chat));
        }
    }

    public static String getIP(){
        Enumeration nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) nis.nextElement();
            Enumeration ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = (InetAddress) ias.nextElement();
                if (!ni.getName().equals("lo"))
                    return ia.getHostAddress().split("%")[0];
            }
        }
        return null;
    }

    public static String printIP(){
        Enumeration nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) nis.nextElement();
            Enumeration ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = (InetAddress) ias.nextElement();
                if (!ni.getName().equals("lo"))
                    System.out.println(ia.getHostAddress());
            }
        }
        return null;
    }
}
