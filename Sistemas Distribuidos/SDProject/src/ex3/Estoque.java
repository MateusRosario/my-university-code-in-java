package ex3;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    List<Produto> produtos = new ArrayList<Produto>();

    public String entrada(Produto produto) {
        Produto item = contains(produto);
        if (item != null) {
            if (item.getQty() + produto.getQty() > 0){
                item.setQty(item.getQty() + produto.getQty());
                return "Estoque atualizado e quantidade atual igual a " + item.getQty();
            } else {
                return "Não é possível fazer a saída de estoque – quantidade menor que o valor desejado";
            }
        } else {
            if (produto.getQty() < 0) {
                return "Produto Inexistente";
            } else {
                produtos.add(produto);
                return "Entrada Realizada, Produto Adicionado";
            }
        }
    }

    public Produto contains(Produto produto) {
        for (Produto item : produtos) {
            if (item.getNome().equals(produto.getNome())) {
                return item;
            }
        }
        return null;
    }
}
