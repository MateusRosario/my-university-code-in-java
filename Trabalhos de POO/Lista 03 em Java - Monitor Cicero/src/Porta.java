public class Porta {
    private boolean estaAberta=false;
    String cor="Sem Cor";
    double dimensaoX=0.80;
    double dimensaoY=1.80;
    double dimensaoZ=0.02;

    public void abre(){   //muda valor da variavel estaAberta para true.
        this.estaAberta=true;
    }

    public void fecha(){    //muda valor da variavel estaAberta para false.
        this.estaAberta=false;
    }

    public void pinta(String cor){  //funciona como um método setCor(); recebe uma sting cor como parametro.
        this.cor=cor;
    }

    public boolean estaAberta(){    //retorna o valor da variavel estaAberta.
        return estaAberta;
    }
}
