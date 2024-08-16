package ex3;

import java.io.Serializable;

public class Produto implements Serializable {
    private int qty;
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

    public String getNome() {
        return nome;
    }

    public boolean addQty(int qty) {
        return true;
    }
}
