package Exercicio3;

public class Torre extends Peca {

    public Torre(String Cor, String tipoPeca) {
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
