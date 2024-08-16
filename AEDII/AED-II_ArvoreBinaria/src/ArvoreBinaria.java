import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class ArvoreBinaria {
    private boolean deBusca;
    private No raiz;
    private List<String> caminhos;

    public ArvoreBinaria(boolean deBusca, int valueRaiz){
        this.deBusca = deBusca;
        this.raiz = new No(valueRaiz);
    }

    public ArvoreBinaria(String arvore){
        arvore = arvore.substring(1,arvore.length());
        String num = "";
        while(arvore.charAt(0) != '(' && arvore.charAt(0) != ')'){
            num = num + arvore.charAt(0);
            arvore = arvore.substring(1, arvore.length());
        }
        raiz = new No(Integer.parseInt(num));
        if (arvore.charAt(0) == '(') {
            arvore = construir(arvore.substring(1,arvore.length()), raiz.esq = new No());
        }
        if (arvore.charAt(0) == '('){
            arvore = construir(arvore.substring(1, arvore.length()), raiz.dir = new No());
        }

        configAlturas(raiz);
        deBusca = verificarDeBusca(raiz);
    }

    private String construir(String arvore, No no){
        String num = "";
        while (arvore.charAt(0) != '(' && arvore.charAt(0) != ')') {
            num = num + arvore.charAt(0);
            arvore = arvore.substring(1, arvore.length());
        }
        no.valor = Integer.parseInt(num);
        if (arvore.charAt(0) == '('){
            arvore = construir(arvore.substring(1,arvore.length()), no.esq =  new No());
        }
        if (arvore.charAt(0) == '('){
            arvore = construir(arvore.substring(1, arvore.length()), no.dir = new No());
        }
        return arvore.substring(1, arvore.length());
    }

    private boolean inserir(No no, No raiz){
        if(raiz == null){
            raiz = no;
            return false;
        }

        if(deBusca){
            if(no.valor > raiz.valor){
                if(raiz.dir != null){
                    raiz.alturaDir++;
                    inserir(no, raiz.dir);
                    balancear(raiz.dir, raiz);
                }else{
                    raiz.alturaDir++;
                    raiz.dir = no;
                    return true;
                }
            }else{
                if(raiz.esq != null){
                    raiz.alturaEsq++;
                    inserir(no, raiz.esq);
                    balancear(raiz.esq, raiz);
                }else{
                    raiz.alturaEsq++;
                    raiz.esq = no;
                    return true;
                }
            }
        }else{
            if(no.alturaDir < no.alturaEsq){
                raiz.alturaDir++;
                inserir(no, raiz.dir);
                return true;
            }else{
                raiz.alturaEsq++;
                inserir(no, raiz.esq);
                return true;
            }
        }
        return false;
    }

    public void inserir(int valor) {
        No no = new No(valor);
        inserir(no, raiz);
        balancear(raiz, raiz);
    }

    private int configAlturas(No no){
        if(no == null){
            return 0;
        }
        no.alturaDir = configAlturas(no.dir);
        no.alturaEsq = configAlturas(no.esq);
        return max(no.alturaDir, no.alturaEsq) + 1;
    }

    private String printInOrdem(No no){
        if(no == null){
            return "";
        }
        String dir;
        String esq;
        dir = printInOrdem(no.dir);
        esq = printInOrdem(no.esq);

        if(dir.equals("") && esq.equals("")){
            return no.valor + "";
        }else if(dir.equals("") && !esq.equals("")){
            return esq + ", " + no.valor;
        }else if(!dir.equals("") && esq.equals("")){
            return no.valor + ", " + dir;
        }
        return esq + ", " + no.valor + ", " + dir;
    }

    public String printInOrdem(){
        return printInOrdem(raiz);
    }

    private String printPreOrdem(No no){
        if(no == null){
            return "";
        }
        String dir;
        String esq;
        dir = printPreOrdem(no.dir);
        esq = printPreOrdem(no.esq);
        if(dir.equals("") && esq.equals("")){
            return no.valor + "";
        }else if(dir.equals("") && !esq.equals("")){
            return no.valor + ", " + esq;
        }else if(!dir.equals("") && esq.equals("")){
            return no.valor + ", " + dir;
        }
        return no.valor + ", " + esq + ", " + dir;
    }

    public String printPreOrdem(){
        return printPreOrdem(raiz);
    }

    private String printPosOrdem(No no){
        if(no == null){
            return "";
        }
        String dir;
        String esq;
        dir = printPosOrdem(no.dir);
        esq = printPosOrdem(no.esq);
        if(dir.equals("") && esq.equals("")){
            return no.valor + "";
        }else if(dir.equals("") && !esq.equals("")){
            return esq + ", " + no.valor;
        }else if(!dir.equals("") && esq.equals("")){
            return dir + ", " + no.valor;
        }
        return  esq + ", " + dir + ", " + no.valor;
    }

    public String printPosOrdem(){
        return printPosOrdem(raiz);
    }

    private boolean verificarDeBusca(No no){
        if(no == null){
            return true;
        }
        if(no.esq != null){
            if(no.esq.valor > no.valor){
                return false;
            }
        }

        if(no.dir != null){
            if(no.dir.valor < no.valor){
                return false;
            }
        }

        return verificarDeBusca(no.esq) && verificarDeBusca(no.dir);
    }

    private boolean getCaminhos(No no, String a){
        if(no == null){
            return true;
        }
        boolean esq = getCaminhos(no.esq, a + no.valor + ", ");
        boolean dir = getCaminhos(no.dir, a + no.valor + ", ");
        if(esq && dir){
            caminhos.add((a + no.valor));
        }
        return false;
    }

    public List<String> getCaminhos(){
        caminhos = new ArrayList<>();
        getCaminhos(raiz, "");
        return caminhos;
    }

    public boolean getDeBusca(){
        return this.deBusca;
    }


    ///////// Rotações simples e dupla ///////////////////////////////////////////

    public void balancear(No no, No raiz){
        int FB;
       FB=no.getFB();

        if (FB==0 || FB==1 || FB==-1){
            return;
        }
        if (FB>1){

            if (no.dir.getFB()==1){
                rotationSimplesEsq(no, raiz, false);
            }else{
                rotationDuplaEsq(no, raiz);
            }
        }else {

            if (no.esq.getFB()== -1){
                rotationSimplesDir(no, raiz, false);
            }else{
                rotationDuplaDir(no, raiz);
            }

        }
    }

    public void rotationSimplesDir(No no, No raiz, boolean rotDupla){
        No B = no.esq;
        no.esq=B.dir;
        B.dir=no;
        if(!no.equals(raiz)) {
            if(rotDupla) {
                raiz.dir = B;
            }else {
                raiz.esq = B;
            }
        }else{
            this.raiz = B;
        }
        configAlturas(raiz);
    }

    public void rotationSimplesEsq(No no, No raiz, boolean rotDupla){
        No B = no.dir;
        no.dir=B.esq;
        B.esq=no;
        if(!no.equals(raiz)) {
            if(rotDupla){
                raiz.esq = B;
            }else {
                raiz.dir = B;
            }
        }else{
            this.raiz = B;
        }
        configAlturas(raiz);
    }

    public void rotationDuplaEsq(No no, No raiz){
        rotationSimplesDir(no.dir,no, true);
        rotationSimplesEsq(no, raiz, true);
    }

    public void rotationDuplaDir(No no, No raiz){
        rotationSimplesEsq(no.esq,no, true);
        rotationSimplesDir(no, raiz, true);
    }

    /////////////////////////////////////////////////////////////////////////

}