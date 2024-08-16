package com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BD {

    private static int tamLinha = 54;
    private String path;
    private String linha = new String();

    public BD(String path){
        this.path=path;
    }

    public void inserir(Produto produto){
        try {
            RandomAccessFile escritor = new RandomAccessFile(this.path, "rw");
            long numlinha = 1;
            while ((linha = escritor.readLine())!= null){
                if (linha.replace("\0","").charAt(0)==' '){
                    atualizar(produto, numlinha);
                    produto.setID(numlinha);
                    escritor.close();
                    return;
                }
                numlinha += 1;
            }

            inserirFinal(produto);
            escritor.close();
            return;
        }catch (Exception e){
            System.out.println("deu errro naquilo la");
        }

    }

    public void atualizar(Produto produto, long linha){
        try {
            RandomAccessFile escritor = new RandomAccessFile(this.path, "rw");
            escritor.seek((linha - 1) * tamLinha);
            escritor.writeBytes(produto.produtoToString() + "\n");
            escritor.close();
        }catch (Exception e){

        }
    }

    public void inserirFinal(Produto produto){
        try {
            RandomAccessFile escritor = new RandomAccessFile(this.path, "rw");
            escritor.seek(escritor.length());
            escritor.writeBytes(produto.produtoToString() + "\n");
            escritor.close();
        }catch (Exception e){

        }
    }

    public List<Produto> pesquisa(String palavraChave){
        List<Produto> produtos = new ArrayList<>();
        String auxi;
        long ID;
        try {
            RandomAccessFile leitor = new RandomAccessFile(this.path, "r");
            ID = 1;
            while ((linha = leitor.readLine())!= null){
                auxi = linha.replace("\0","");
                if(auxi.charAt(0) == ' '){
                    continue;
                }
                if (auxi.contains(palavraChave)){
                    produtos.add(new Produto(linha, ID));
                }
                ID++;
            }
            leitor.close();
        }catch (Exception e){
        }
        return produtos;
    }

    public boolean deletar(long numLinha){
        try {
            RandomAccessFile delete = new RandomAccessFile(this.path, "rw");
            delete.seek((numLinha-1) * tamLinha);
            delete.writeBytes(" ");
            delete.close();
        }catch (Exception e){

        }

        return false;
    }
}