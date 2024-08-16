public class Casa {
    String cor="Sem cor";
    Porta[] portas;
    private int livre;
    private int quantidadeDePortas=-1;

    public void pinta(String cor){  //funciona como um método setCor(); recebe uma sting cor como parametro.
        this.cor=cor;
    }

    public void criarPortas(int quantidadeDePortas){    //recebe o número de portas da casa.
        if(this.quantidadeDePortas==-1) {        //confere se o numero de portas já foi definido.
            this.quantidadeDePortas = quantidadeDePortas;   //define número de portas.
            this.portas = new Porta[quantidadeDePortas]; //cria array de portas.
            livre = 0; //define indice do array de portas livre.
        }else{
            System.out.println("Quantidade de portas já definidas.");
        }
    }

    public int quantasPortasEstaoAbertas(){ //verifica todas as potas abertas.
        int cont=0;
        for(int i=0; i<portas.length; i++){
            if(portas[i].estaAberta()){
                cont++;
            }
        }
        return cont; //retorna número de portas abertas.
    }

    public void colocarPortas(Porta porta){  //recebe objetos portas, e o coloca no array
        if(quantidadeDePortas!=-1) {        //verifica se o número de portas já foi definido.
            if (livre < quantidadeDePortas) {  //verifica se a lugares para porta livre.
                this.portas[livre] = porta; //coloca objeto porta no array.
                livre++;
            } else {
                System.out.println("Todas as portas já colocadas.");
            }
        }else{
            System.out.println("Número de portas não definido");
        }
    }
}
