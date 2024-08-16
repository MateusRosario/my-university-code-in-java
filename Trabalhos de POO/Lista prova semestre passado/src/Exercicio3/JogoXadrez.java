package Exercicio3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class JogoXadrez {
    private static Tabuleiro tabuleiro=new Tabuleiro();
    private static List capBrancas=new ArrayList();
    private static List capPretas=new ArrayList();

    public static void jogar(){
        String jogando="Branca";
        System.out.println("Iniciando Jogo\n");
        do{
            System.out.println("\n\nVez das " + jogando + "s.\n");
            listarCapPretas();
            tabuleiro.imprimir();
            listarCapBrancas();
            if(jogando=="Branca"){
                tabuleiro.mover(jogando,capBrancas);
            }else{
                tabuleiro.mover(jogando,capPretas);
            }
            if(tabuleiro.reiCapiturado(jogando)==true){
                System.out.println("\nAs peças " + jogando + "s ganharam.\n");
                reposicionarPecas();
                break;
            }
            if(jogando=="Branca"){
                jogando="Preta";
            }else{
                jogando="Branca";
            }
        }while(true);
    }

    public static void listarCapBrancas(){
        Peca temp;
        System.out.println("\nPeças Capituradas pelas Brancas");
        System.out.print("[|");
        for(int i=0;i<capBrancas.size();i++){
            temp=(Peca) capBrancas.get(i);
            System.out.print(temp.getTipoPeca().charAt(0) + "|");
        }
        System.out.println("]\n");
    }

    public static void listarCapPretas(){
        Peca temp;
        System.out.println("\nPeças Capituradas pelas Pretas");
        System.out.print("[|");
        for(int i=0;i<capPretas.size();i++){
            temp=(Peca) capPretas.get(i);
            System.out.print(temp.getTipoPeca().charAt(0) + "|");
        }
        System.out.print("]\n");
    }

    public static void reposicionarPecas(){
        tabuleiro.resetar();
        tabuleiro.posicionarBrancas();
        tabuleiro.posicionarPretas();
    }

    public static void main(String[] args){
        Scanner ent=new Scanner(System.in);
        char ch;
        boolean sair = false;
        do {
            System.out.println("(Menu)");
            System.out.println("(1)Iniciar Partida.");
            System.out.println("(2)Sair");
            ch = ent.next().charAt(0);
            switch (ch) {
                case '1':
                    jogar();
                    break;
                case '2':
                    sair = true;
                    break;
            }
        }while (sair==false);
    }
}
