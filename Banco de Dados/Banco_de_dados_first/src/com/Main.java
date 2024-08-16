package com;

import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private HashMap<String, BD> BancosDeDados;
    private List<String> chaves;

    public static void main(String[] args) {
        int Largura = 400;
        int Altura = 250;
        Main main = new Main();
        main.loadBancos();
        TelaMain telaMain = new TelaMain(Largura, Altura, main);
    }

    public void loadBancos(){
        File dir = new File(".");
        chaves = new ArrayList<String>();
        BancosDeDados = new HashMap<String, BD>();
        String[] listaDeBD = dir.list();
        for (int i = 0; i < listaDeBD.length ; i++) {
            if(listaDeBD[i].contains(".dat")) {
                chaves.add(listaDeBD[i].substring(0,listaDeBD[i].length() - 4));
                BancosDeDados.put(listaDeBD[i].substring(0,listaDeBD[i].length() - 4), new BD(listaDeBD[i]));
            }
        }
    }

    public List<String> getBancos(){
        return chaves;
    }

    public boolean criarBD(String nome){
        File novoBD = new File(nome + ".dat" );
        try {
            if(!novoBD.createNewFile()){
                return false;
            }
        }catch (Exception e){
        }
        BD bd = new BD(nome + ".dat");
        chaves.add(nome);
        BancosDeDados.put(nome, bd);
        return true;
    }

    public void excluirBD(String nome){
        File BD = new File(nome + ".dat");
        BD.delete();
        chaves.remove(nome);
        BancosDeDados.remove(nome);
    }

    public BD getSelecionado(String nome){
        return BancosDeDados.get(nome);
    }

    public String[] getBancosArray(){
        String[] data = new String[chaves.size()];
        for (int i = 0; i < chaves.size() ; i++) {
            data[i]= chaves.get(i);
        }
        return data;
    }
}