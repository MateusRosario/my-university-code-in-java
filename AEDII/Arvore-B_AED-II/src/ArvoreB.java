public class ArvoreB {
    Nodo raiz;
    public ArvoreB(int ordem){
        raiz = new Nodo(ordem, this);
    }

    public void inserir(int c){
        raiz.inserir(c);
    }
}
