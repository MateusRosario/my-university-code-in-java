package Exercicio3;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Tabuleiro {
    Scanner ent=new Scanner(System.in);
    private Peca[][] tab=new Peca[8][8];

   public Tabuleiro(){
       inserirPecas();
   }

   public void inserirPecas(){
       System.out.println("Posicionado peças Brancas: \n");
       posicionarBrancas();
       System.out.println("Posicionado peças Pretas: \n");
       posicionarPretas();
   }

   public void posicionarBrancas(){
     posicionandoPeoes("Branca");
     posicionandoTorres("Branca");
     posicionandoCavalos("Branca");
     posicionandoBispos("Branca");
     posicionandoDamaRei("Branca");
   }

    public void posicionarPretas(){
        posicionandoPeoes("Preta");
        posicionandoTorres("Preta");
        posicionandoCavalos("Preta");
        posicionandoBispos("Preta");
        posicionandoDamaRei("Preta");
    }

   public void posicionandoPeoes(String cor){
       int x=0,y=0;
       if(cor=="Branca"){
           y=1;
       }else{
           y=6;
       }
       for(x=0;x<=7;x++) {
               tab[x][y]= new Peao(cor, "Peao");
       }
   }

   public void posicionandoTorres(String cor){
       int x=0,y=0;
       if(cor=="Preta"){
           y=7;
       }
       for(x=0;x<=7;x=x+7) {
           tab[x][y]= new Torre(cor, "Torre");
       }
   }

   public void posicionandoCavalos(String cor){
       int x=0,y=0;
       if(cor=="Preta"){
           y=7;
       }
       for(x=1;x<=7;x=x+5) {
           tab[x][y]= new Cavalo(cor, "Cavalo");
       }
   }

   public void posicionandoBispos(String cor){
       int x=0,y=0;
       if(cor=="Preta"){
           y=7;
       }
       for(x=2;x<=7;x=x+3) {
           tab[x][y]= new Bispo(cor, "Bispo");
       }
   }

   public void posicionandoDamaRei(String cor){
       if(cor=="Branca"){
           tab[3][0]= new Dama(cor, "Dama");
           tab[4][0]= new Rei(cor, "Rei");
       }else{
           tab[3][7]= new Dama(cor, "Dama");
           tab[4][7]= new Rei(cor, "Rei");
       }
   }

   public void mover(String jogando,List cap){
        int xlocal, ylocal, xobjetivo, yobjetivo;
        String inimigas;
        boolean ficar=true,sair=true,capiturar=false;
        do {
            System.out.println("Deseja mover qual peça: ");
            System.out.println("Posição x: ");
            xlocal = ent.nextInt();
            System.out.println("Posição y: ");
            ylocal = ent.nextInt();
            xlocal--;
            ylocal--;
            if(tab[xlocal][ylocal]!=null) {
                if (tab[xlocal][ylocal].getTipoPeca() == "Cavalo" && tab[xlocal][ylocal].getCor() == jogando) {
                    ficar = false;
                } else {
                    System.out.println("Só é possivel mover cavalos de cor " + jogando);
                }
            }
        }while(ficar);
        do {
            System.out.println("Digite o local objetivo: ");
            System.out.println("Posição x: ");
            xobjetivo = ent.nextInt();
            System.out.println("Posição y: ");
            yobjetivo = ent.nextInt();
            xobjetivo--;
            yobjetivo--;
            sair=tab[xlocal][ylocal].mover(xlocal, ylocal, xobjetivo, yobjetivo);
            if(sair){
                if(tab[xobjetivo][yobjetivo]!=null) {
                    if (tab[xobjetivo][yobjetivo].getCor() == jogando) {
                        System.out.println("Movimento Invalido");
                        sair = false;
                    }else{
                        capiturar=true;
                    }
                }
            }else{
                System.out.println("Movimento Invalido");
            }
        }while(sair==false);

        if(capiturar){
            cap.add(tab[xobjetivo][yobjetivo]);
            tab[xobjetivo][yobjetivo]=tab[xlocal][ylocal];
            tab[xlocal][ylocal]=null;
        }else{
            tab[xobjetivo][yobjetivo]=tab[xlocal][ylocal];
            tab[xlocal][ylocal]=null;
        }
   }

   public void imprimir(){
       System.out.println("   01 02 03 04 05 06 07 08 ");
       for(int c=7; c>=0; c--){
           System.out.print((c+1) +" " + "|");
           for(int l=0;l<=7;l++){
               if(tab[l][c]!=null) {
                   System.out.printf("%c%c|", tab[l][c].getTipoPeca().charAt(0), tab[l][c].getCor().charAt(0));
               }else{
                   System.out.print("[]|");
               }
           }
           System.out.println();
       }
   }

   public boolean reiCapiturado(String jogando){
       if(jogando=="Branca"){
           if(tab[4][7].getTipoPeca()!="Rei"){
               return true;
           }
       }else{
           if(tab[4][0].getTipoPeca()!="Rei"){
               return true;
           }
       }
       return false;
   }

   public void resetar(){
       for(int i=0;i<=7;i++){
           for(int a=0;a<=7;a++){
               tab[a][i]=null;
           }
       }
   }
}
