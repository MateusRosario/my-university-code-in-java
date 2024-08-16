package teste;

public class MinhaOutraThread extends Thread {
    private int tick=1;
    private int num;
    public MinhaOutraThread(int num){
        this.num=num;
    }

    public void run(){
        while (tick <200000){
            tick++;
            if((tick % 50000) == 0){
                System.out.println("Thread#" + num + ", tick =" + tick);
            }
        }
    }
}

class Principal {
    private final static int AUX = 2;

    public static void main(String[] args) {
        MinhaOutraThread[] runners = new MinhaOutraThread[AUX];
        for (int i = 0; i < AUX ; i++) {
            runners[i] = new MinhaOutraThread(i);
            runners[i].setPriority(2);
        }
        for (int i = 0; i < AUX; i++) {
            runners[i].start();
        }
    }
}