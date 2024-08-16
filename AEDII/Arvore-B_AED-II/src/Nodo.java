public class Nodo {
    int numChaves = 0;
    int numfilhos = 0;
    int[] chaves;
    Nodo[] filhos;
    int ordem;
    ArvoreB arvore;

    public Nodo(int ordem, ArvoreB arvore){
        this.ordem = ordem;
        chaves = new int[ordem-1];
        filhos = new Nodo[ordem];
        this.arvore = arvore;
    }

    public int inserir(int c){
        int retorno;
       if(numfilhos == 0){
           return inserirInThisNodo(c);
       }else{

           for (int i = 0; i <numChaves; i++) {
               if(c < chaves[i]){
                   if(filhos[i]!= null) {
                       retorno = filhos[i].inserir(c);
                       if (retorno != -1) {
                           if(numfilhos<ordem) {
                               this.filhos[i+1] = new Nodo(ordem, null);
                               this.filhos[i+1].inserir(this.filhos[i].removeChave(2));
                               this.filhos[i+1].inserir(this.filhos[i].removeChave(3));
                               this.numfilhos++;
                               return inserirInThisNodo(retorno);
                           }else{
                               return inserirInThisNodo(retorno);
                           }
                       } else {
                           return -1;
                       }
                   }else{
                       filhos[i] = new Nodo(ordem, null);
                       numfilhos++;
                       return filhos[i].inserir(c);//Como este filho está vazio, o elemento vai ser inserido nele.
                   }
               }
           }
           retorno = filhos[numfilhos-1].inserir(c);
           if(retorno != -1){
               if(numfilhos<ordem) {
                   this.filhos[numfilhos] = new Nodo(ordem, null);
                   this.filhos[numfilhos].inserir(this.filhos[numfilhos - 1].removeChave(2));
                   this.filhos[numfilhos].inserir(this.filhos[numfilhos - 1].removeChave(2));
                   this.numfilhos++;
                   return inserirInThisNodo(retorno);
               }else{
                   return inserirInThisNodo(retorno);
               }
           }
       }
       return -1;
    }

    public int inserirInThisNodo(int c){
        if(numChaves < (ordem-1)) {
            inserirInChaves(c);
        }else{
            if(this.arvore == null) {
                return getMediano(c);
            }else{
                arvore.raiz = new Nodo(ordem, arvore);
                arvore.raiz.inserir(getMediano(c));
                arvore.raiz.filhos[0] = this;
                arvore.raiz.filhos[1] = new Nodo(ordem, null);//Novo nodo recebe nulo pois não é raiz;
                arvore.raiz.filhos[1].inserir(removeChave(2));
                arvore.raiz.filhos[1].inserir(removeChave(2));
                arvore.raiz.numfilhos = 2;
                transfeririFilhos(c);
                this.arvore = null;
                return -1;
            }
        }
        return -1;
    }

    public void transfeririFilhos(int c){

    }

    public boolean inserirInChaves(int c){
        for (int i = 0; i <numChaves ; i++) {
            if(c < chaves[i]){
                inserirChave(c,i);
                numChaves++;
                return true;
            }
        }
        chaves[numChaves] = c;
        numChaves++;
        return true;
    }

    public boolean inserirChave(int c, int pos){
        int temp;
        for(int i = pos;i<=numChaves;i++){
            temp = chaves[i];
            chaves[i] = c;
            c = temp;
        }

        return true;
    }

    public int getMediano(int c){
        if(c>chaves[1]){
            if(c<chaves[2]){
                return c;
            }else{
                int removido = removeChave(2);
                inserirInChaves(c);
                return removido;
            }
        }else{
            int removido = removeChave(1);
            inserirInChaves(c);
            return removido;
        }
    }

    public int removeChave(int pos){
        int removido = chaves[pos];
        for(int i = pos;i<numChaves-1;i++){
            chaves[i] = chaves[i+1];
        }
        numChaves--;
        chaves[numChaves] = 0;
        return removido;
    }
}
