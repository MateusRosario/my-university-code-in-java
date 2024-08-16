package Exercicio3;

public class Cavalo extends Peca {

    public Cavalo(String Cor, String tipoPeca) {
        super(Cor, tipoPeca);
    }

    @Override
    public String getTipoPeca() {
        return super.getTipoPeca();
    }

    @Override
    public boolean mover(int xl, int yl, int xo, int yo) {
        if(((xo==xl-2 && yo==yl+1) || (xo==xl-1 && yo==yl+2) || (xo==xl+1 && yo==yl+2) || (xo==xl+2 && yo==yl+1) || (xo==xl-2 && yo==yl-1) || (xo==xl-1 && yo==yl-2) || (xo==xl+1 && yo==yl-2) || (xo==xl+2 && yo==yl-1)) && yo>=0 && yo<=7 && xo>=0 && xo<=7){
            return true;
        }else{
            return false;
        }

    }
}

