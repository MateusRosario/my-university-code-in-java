import static java.lang.Math.max;

public class No {
    int valor;
    No dir;
    int alturaDir;
    No esq;
    int alturaEsq;

    public No(int valor){
        this.valor = valor;
        dir = null;
        alturaDir = 0;
        esq = null;
        alturaEsq = 0;
    }

    public No(){
        this.valor = 0;
        dir = null;
        alturaDir = 0;
        esq = null;
        alturaEsq = 0;
    }

    public int getAltura(){
        return max(alturaDir,alturaEsq) + 1;
    }

    public int getFB(){
        return alturaDir-alturaEsq;
    }
}