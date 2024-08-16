package Corrida_threrd;

public class Corredor extends Thread {
    private int posição=0;
    private int tam;

    public Corredor(int tam){
        this.tam=tam;
    }

    public void run(){
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while(posição<tam){
            posição++;
        }
    }

    public int getPosicao(){
        return posição;
    }
}
