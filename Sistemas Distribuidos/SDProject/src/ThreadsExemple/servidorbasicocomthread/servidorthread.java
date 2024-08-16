package ThreadsExemple.servidorbasicocomthread;

import java.net.*;
import java.io.*;

public class servidorthread extends Thread{
  public Socket s1;
  
  servidorthread(Socket s1){
	  super();
	  this.s1=s1;
  }

  public void run(){
	   DataOutputStream s1out;
	   String cadena = "Tutorial de Java!";
	  
	  try{
		 s1out = new DataOutputStream(s1.getOutputStream());
		 s1out.writeUTF(cadena);    
         s1.close();
	  }
      catch(Exception e){
		 System.out.println("Erro="+e.getMessage());
      }  
  }
  

}//fim da classe