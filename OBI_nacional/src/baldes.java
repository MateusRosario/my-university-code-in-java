import java.util.ArrayList;
import java.util.Scanner;

public class baldes {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int N,M;
        N = ent.nextInt();
        M = ent.nextInt();

        ArrayList<balde> baldes = new ArrayList<balde>();
        for (int i = 0; i < N; i++) {
            int temp = ent.nextInt();
            baldes.add(new balde(temp));
        }

        int op;//A
        int I;//B
        for (int i = 0; i < M; i++) {
            op = ent.nextInt();
            if(op == 1){
                op = ent.nextInt();
                I = ent.nextInt();
                baldes.get(I-1).inserir(op);
            }else{
                op = ent.nextInt();
                I = ent.nextInt();

                for (int j = 0; j < baldes.size(); j++) {
                    baldes.get(j).setMaior();
                    baldes.get(j).setMenor();
                }

                boolean first;
                int tentativa = 0;
                int menorDif = 0;
                int maiorDif = 0;
                int menor = 0;
                int maior = 0;
                int maiorPos = 0;
                int menorPos = 0;

                do {
                    first = true;
                    for (int j = op-1; j < I; j++) {
                        if(tentativa == 0) {
                            if (first) {
                                menor = baldes.get(j).getMenor();
                                menorPos = j;
                                maior = baldes.get(j).getMaior();
                                maiorPos = j;
                                first = false;
                            } else {
                                if (menor > baldes.get(j).getMenor()) {
                                    menor = baldes.get(j).getMenor();
                                    menorPos = j;
                                }
                                if (maior < baldes.get(j).getMaior()) {
                                    maior = baldes.get(j).getMaior();
                                    maiorPos = j;
                                }
                            }
                        }else{
                            if (first) {
                                if(menorPos != j) {
                                    menorDif = baldes.get(j).getMenor();
                                    first = false;
                                }
                                if(maiorPos != j){
                                    if(maiorDif < baldes.get(j).getMaior()){
                                        maiorDif = baldes.get(j).getMaior();
                                    }
                                }
                            } else {
                                if(menorPos != j) {
                                    if (menorDif > baldes.get(j).getMenor()) {
                                        menorDif = baldes.get(j).getMenor();
                                    }
                                }
                                if(maiorPos != j) {
                                    if (maiorDif < baldes.get(j).getMaior()) {
                                        maiorDif = baldes.get(j).getMaior();
                                    }
                                }
                            }
                        }
                    }

                    if(tentativa == 0) {
                        if (maiorPos != menorPos) {
                            break;
                        } else {
                            tentativa++;
                        }
                    }else{
                        if(maior - menorDif > maiorDif - menor){
                            menor = menorDif;
                            break;
                        }else{
                            maior = maiorDif;
                            break;
                        }
                    }
                }while (true);

                System.out.println(maior - menor);
            }
        }
    }
}

class balde{
    ArrayList<Integer> bolas = new ArrayList<Integer>();
    int Menor;
    int Maior;
    public balde(int bola){
        bolas.add(bola);
    }

    public void inserir(int bola){
        bolas.add(bola);
    }

    public void setMenor(){
        int menor = 0;
        for (int i = 0; i < bolas.size() ; i++) {
            if(i == 0){
                menor = bolas.get(i);
            }else{
                if(menor > bolas.get(i)){
                    menor = bolas.get(i);
                }
            }
        }
        Menor = menor;
    }

    public void setMaior(){
        int maior = 0;
        for (int i = 0; i < bolas.size() ; i++) {
            if(maior < bolas.get(i)){
                    maior = bolas.get(i);
            }
        }
        Maior = maior;
    }

    public int getMenor() {
        return Menor;
    }

    public int getMaior() {
        return Maior;
    }
}
