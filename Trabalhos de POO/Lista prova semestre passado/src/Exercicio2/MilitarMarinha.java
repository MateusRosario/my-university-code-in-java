package Exercicio2;
import java.util.Scanner;

public class MilitarMarinha extends Militar{
    private Scanner ent=new Scanner(System.in);
    private boolean concertou;

    public MilitarMarinha(int patente){
        super(patente,"Marinha");
    }

    @Override
    public void setDados() {
        char c;
        System.out.println("Este militar consertou algum navio em alto mar com esta a patente " + getPatenteString() + "?  (s)sim (n)não");
        c=ent.next().charAt(0);
        if(c=='s'){
            concertou=true;
        }else{
            concertou=false;
        }
    }

    @Override
    public boolean isHabilitado() {
        if(super.getPatente()<2) {
            if(concertou==true){
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
        concertou=false;
    }

    @Override
    public void impressao(){
        System.out.println("matricula: " + getMatricula());
        System.out.println("patente: " + getPatenteString());
        if(concertou==true){
            System.out.println("Concertou um navio em alto mar com está patente.");
        }else{
            System.out.println("Não concertou um navio em alto mar com está patente");
        }

    }
}
