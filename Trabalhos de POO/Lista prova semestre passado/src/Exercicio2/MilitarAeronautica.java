package Exercicio2;
import java.util.Scanner;

public class MilitarAeronautica extends Militar {
    private Scanner ent=new Scanner(System.in);
    private int anos_pat;
    private int horas;

    public MilitarAeronautica(int patente){
        super(patente,"Aeronautica");
    }

    @Override
    public void setDados() {
        System.out.println("A quantos anos este militar esta na patente de " + getPatenteString() + "?");
        anos_pat = ent.nextInt();
        ent.nextLine();
        System.out.println("Quantas horas de voo o militar o possui nesta patente?");
        horas = ent.nextInt();
        ent.nextLine();
    }

    public boolean isHabilitado() {
        if(super.getPatente()<2) {
            if (anos_pat > 2 && horas > 100) {
                return true;
            } else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void subirPatente() {
        super.subirPatente();
        anos_pat=0;
        horas=0;
    }

    @Override
    public void impressao(){
        System.out.println("matricula: " + getMatricula());
        System.out.println("patente: " + getPatenteString());
        System.out.println("Anos nesta patente: " + anos_pat);
        System.out.println("Horas de voo: " + horas);

    }
}
