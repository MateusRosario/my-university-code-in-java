package Exercicio3;

public abstract class Peca {
    private String cor;
    private String tipoPeca;

    public Peca(String cor,String tipoPeca){
        this.cor=cor;
        this.tipoPeca=tipoPeca;
    }

    public String getTipoPeca(){
        return tipoPeca;
    }

    public String getCor(){
        return cor;
    }

    public abstract boolean mover(int xl, int yl, int xo, int yo);
}
