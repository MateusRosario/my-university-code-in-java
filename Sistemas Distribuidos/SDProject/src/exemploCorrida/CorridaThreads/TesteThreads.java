package exemploCorrida.CorridaThreads;

public class TesteThreads extends Thread{
  int numrodadas;	
  public TesteThreads(String nome, int n){  
    super(nome); // chama o método contrutor da classe pai (no caso a classe Thread)
	numrodadas=n;
  }
  public void run(){
    for(int i=0;i<numrodadas;i++){
      System.out.println(getName()+" na etapa"+i);
      try{
        sleep((int)(Math.random()*2000));
      }catch(Exception e){}
    }
    System.out.println("Thread terminada: "+getName());
  }
}
