package Corrida_threrd;

import java.util.ArrayList;
import java.util.List;

public class Shower extends Thread {


    private List<Corredor> corredores;
    private int tam;
    public Shower(List<Corredor> corredores,int tam){
        this.corredores = corredores;
        this.tam=tam;
    }

    public void run(){
        for (int i = 0; i < corredores.size() ; i++) {
            corredores.get(i).start();
        }

        do {


            int maior = 0;
            int menor = tam;
            for (int i = 0; i < corredores.size(); i++) {
                if (corredores.get(i).getPosicao() > maior) {
                    maior = corredores.get(i).getPosicao();
                }

                if (corredores.get(i).getPosicao() < menor) {
                    menor = corredores.get(i).getPosicao();
                }
            }

            for (int i = maior; i > menor; i--) {
                System.out.print(String.format("%3d|",i));
                for (int j = 0; j < corredores.size(); j++) {
                    if (corredores.get(j).getPosicao() == i) {
                        System.out.print(" O ");
                    }
                }
                System.out.println();
            }

            if(maior>=tam){
                this.stop();
            }


            for (int i = 0; i < corredores.size() ; i++) {
                synchronized (corredores.get(i)) {
                    corredores.get(i).notify();
                }
            }
        }while (true);
    }



    public static void main(String[] args) {
        List<Corredor> corredores = new ArrayList<Corredor>();
        for (int i = 0; i < 4; i++) {
            corredores.add(new Corredor(40));
        }

        Shower shower = new Shower(corredores,40);

        shower.setPriority(10);



        shower.start();

    }
}
