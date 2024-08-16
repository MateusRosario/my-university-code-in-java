package Exercicio2;

public abstract class Militar {
    private int patente;
    private static int ultiMatricula=20180000;
    private int matricula;
    private String force;
    private static final String[] patentes=new String[]{"Soldado","Cabo","Tenente"};

    public Militar(int patente,String force){
        this.patente=patente;
        this.matricula=++ultiMatricula;
        this.force=force;
    }

    public abstract void setDados();

    public abstract boolean isHabilitado();

    public void subirPatente() {
        if(isHabilitado()==true){
            patente++;
        }else{
            System.out.println("Não é possivel subir de Patente.");
        }
    }

    public int getMatricula(){
        return matricula;
    }

    public int getPatente() {
        return patente;
    }

    public String getPatenteString(){
        return patentes[patente];
    }

    public String getForce(){
        return force;
    }

    public abstract void impressao();
}
