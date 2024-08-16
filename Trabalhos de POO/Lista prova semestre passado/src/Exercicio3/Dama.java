package Exercicio3;

public class Dama extends Peca {

    public Dama(String Cor, String tipoPeca) {
        super(Cor, tipoPeca);
    }


    @Override
    public String getTipoPeca() {
        return super.getTipoPeca();
    }

    @Override
    public boolean mover(int xl, int yl, int xo, int yo) {
        return false;
    }

}
