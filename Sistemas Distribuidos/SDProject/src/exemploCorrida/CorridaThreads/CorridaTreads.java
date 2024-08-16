package exemploCorrida.CorridaThreads;

public class CorridaTreads {
  public static void main (String args[]){
    TesteThreads a,b;
    a = new TesteThreads("A1",10);
    a.start();
    b = new TesteThreads("B1",10);
    b.start();
    try{a.join();}catch(Exception e){}
    try{b.join();}catch(Exception e){}
	System.out.println("\nThread Master Terminada");
  }
}
