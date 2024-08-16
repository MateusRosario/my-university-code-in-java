/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemas_distribuidos.n1;

/**
 *
 * @author batista
 */
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

class Cliente{
    public static void main( String args[] ) throws IOException {
        int porta,  numero=0;
	String msg;
        Socket s;
        DataInputStream sIn;
         DataOutputStream sOut;
         String ip;
        

        try {
            /*
            s = new Socket(InetAddress.getByName("127.0.0.1"),4321 ); //pelo numero IP
           */
           s = new Socket();
         
            ip = JOptionPane.showInputDialog("Digite o ip: ");
            porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta: "));
           
           InetSocketAddress endereco = new InetSocketAddress(ip, porta);
           s.connect(endereco,1000);  
            
           sIn = new DataInputStream(s.getInputStream());
            
 	
        while( true ){
            
            for(int i=0;i<3;i++){
                numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero:"));
                sOut = new DataOutputStream(s.getOutputStream());
                    /*longCad = cadena.length();
                    for( int i=0; i < longCad; i++ )
                        s1out.write( (int)cadena.charAt( i ) );
                     */
                sOut.writeInt(numero); 
                if(numero <0){
                break;
                }
            }
                if(numero <0){
                break;
                }
            msg=sIn.readUTF();
            System.out.println("\nMensagem recebida: "+msg); 
            
            //msg=sIn.readUTF();
            //System.out.println("\nMensagem recebida: "+msg);  
            
        }
        //mensagem=sIn.readUTF();
        //System.out.println("\nMensagem recebida: "+mensagem); 
        s.close();
 
        }catch( IOException e ) {
            System.out.println( e );
        }
  }
}