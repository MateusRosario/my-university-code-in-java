package com;

import java.text.DateFormat;
import java.util.Date;

public class Produto {
    private static int tamNome = 30;
    private static int tamPreco = 7;
    private static int tamData = 10;
    private long ID;
    private String nome;
    private String preco;
    private String data;

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
        Date data = new Date();
        this.data = DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
    }

    public Produto(String linha, long ID){
        this.ID = ID;
        int cont = 0;
        int checkPoint = 0;
        for (int i = 0; i < linha.length() ; i++) {
            if(linha.charAt(i) == ';'){
                switch (cont){
                    case 0:
                        nome = linha.substring(0, i).replace("\0", "");
                        checkPoint = i;
                        cont++;
                        break;
                    case 1:
                        preco = linha.substring(checkPoint+1,i).replace("\0","");
                        checkPoint = i;
                        cont++;
                        break;
                    case 2:
                        data = linha.substring(checkPoint+1,i).replace("\0", "");
                        break;
                }
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public String getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String produtoToString(){
        StringBuilder nome = new StringBuilder(this.nome);
        nome.setLength(30);
        StringBuilder preco = new StringBuilder(this.preco);
        preco.setLength(7);
        return nome.toString() + "; " + preco.toString() + "; " + data + "; ";
    }

    public  String Complementonome(String n){
        int tam = n.length();
        if(tam < 30){
            int complemento = 20-tam;
            for(int i=0; i<complemento; i++){
                n+="\0";
            }
        }
        return n;
    }

    public String produtoToStringNormal(){
        return nome + "; " + preco + "; " + data + ";";
    }
}