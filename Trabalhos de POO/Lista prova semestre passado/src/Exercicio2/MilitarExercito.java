package Exercicio2;
import java.util.Scanner;

public class MilitarExercito extends Militar {
    private Scanner ent=new Scanner(System.in);
    private boolean winWar;

    public MilitarExercito(int patente) {
        super(patente,"Exercito");
    }

    @Override
    public void setDados() {
        char c;
        System.out.println("Este miltar já venceu alguma guerra na patente de " + getPatenteString() + "?");
        c=ent.next().charAt(0);
        if(c=='s'){
            winWar=true;
        }else{
            winWar=false;
        }
    }

    @Override
    public boolean isHabilitado() {
        if(super.getPatente()<2) {
            if(winWar==true){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void subirPatente() {
        super.subirPatente();
        winWar=false;
    }

    @Override
    public void impressao(){
        System.out.println("matricula: " + getMatricula());
        System.out.println("patente: " + getPatenteString());
        if(winWar==true){
            System.out.println("Concertou um navio em alto mar com está patente.");
        }else{
            System.out.println("Não concertou um navio em alto mar com está patente");
        }
    }
}
