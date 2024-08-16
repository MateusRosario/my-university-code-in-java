package ThreadsExemple.servidorbasicocomthread;

import java.net.*;
import java.io.*;

class servidor3 {
    public static void main( String args[] ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
        

        try {
            s = new ServerSocket( 4321,300 );
        } catch( IOException e ) {
            System.out.println( e );
        }

        while( true ) {
            try {

                s1 = s.accept();
				
				servidorthread st = new servidorthread(s1);
				st.start();
                
            } catch( IOException e ) {
                System.out.println( e );
            }
        }
    }
}
