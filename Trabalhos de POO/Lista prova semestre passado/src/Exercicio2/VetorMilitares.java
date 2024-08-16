package Exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VetorMilitares {
    static boolean iniciado=false;
    private static List M=new ArrayList();
    static int tam=0;

    public static void novoMilitar(){
        Scanner ent=new Scanner(System.in);
        char dep;
        int patente;
        System.out.println("Este militar esta inserido no: \n(1)Exercito\n(2)Marinha\n(3)Aeronautica");
        dep=ent.next().charAt(0);
        System.out.println("Qual a patente deste militar? \n(1)Soldado\n(2)Cabo\n(3)Tenente");
        patente=ent.nextInt();
        switch(dep){
            case '1':
                    M.add(new MilitarExercito(patente-1));
                break;
            case '2':
                    M.add(new MilitarMarinha(patente-1));
                break;
            case '3':
                    M.add(new MilitarAeronautica(patente-1));
                break;
        }
    }

    public static void listarMilitares(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++){
            temp= (Militar) M.get(i);
            System.out.println("(" + (i+1) + ") . " + "matricula: " + temp.getMatricula() + " >> Força militar: " + temp.getForce() + " >> Patente: " + temp.getPatenteString() + ".");
        }
        System.out.println("\n");

    }

    public static void setDados(){
        Scanner ent = new Scanner(System.in);
        int ch;
        Militar temp;
        System.out.println("Escolha um militar: ");
        listarMilitares();
        ch=ent.nextInt();
        ch--;
        temp=(Militar) M.get(ch);
        temp.setDados();
    }

    public static void subirPatente(){
        Scanner ent = new Scanner(System.in);
        int ch;
        Militar temp;
        System.out.println("Escolha um militar: ");
        listarMilitares();
        ch=ent.nextInt();
        ch--;
        temp=(Militar) M.get(ch);
        temp.subirPatente();
    }

    public static void impressao(){
        Scanner ent = new Scanner(System.in);
        int ch;
        Militar temp;
        System.out.println("Escolha um militar: ");
        listarMilitares();
        ch=ent.nextInt();
        ch--;
        temp=(Militar) M.get(ch);
        temp.impressao();
    }

    public static void imprimirHabilitados(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++){
            temp= (Militar) M.get(i);
            if(temp.isHabilitado()){
                temp.impressao();
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void subirHabilitados(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++) {
            temp = (Militar) M.get(i);
            if (temp.isHabilitado()) {
                subirPatente();
            }
        }
        System.out.println("\n");
    }

    public static void impressaoAeronautica(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++){
            temp= (Militar) M.get(i);
            if(temp.getForce()=="Aeronautica"){
                temp.impressao();
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void impressaoExercito(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++){
            temp= (Militar) M.get(i);
            if(temp.getForce()=="Exercito"){
                temp.impressao();
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void impressaoMarinha(){
        Militar temp;
        System.out.println("\n");
        for(int i=0;i<M.size();i++){
            temp= (Militar) M.get(i);
            if(temp.getForce()=="Marinha"){
                temp.impressao();
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        char sh;
        boolean ficar=true;
        System.out.println("Iniciando progama de cadastro militar");
        do {
            System.out.println("\n\nO que deseja executar:\n(1)Cadastrar novo militar.\n(2)Listar militares cadastrados.\n(3)Adicionar\\atualizar dados.\n(4)Subir patente de algum militar.\n(5)Imprimir todos os dados de um militar.");
            System.out.println("(6)Imprimir os dados de todos habilitados a subir de patente.\n(7)Subir patente de todos habilitados.\n(8)Imprimir dados de todos da Aeronautica.\n(9)Imprimir dados de todos da Exercito\n(A)Imprimir dados de todos da Marinha.\n(B)Fechar progama.\n");
            sh = ent.next().charAt(0);
            switch (sh) {
                case '1':
                    novoMilitar();
                    break;
                case '2':
                    listarMilitares();
                    break;
                case '3':
                    setDados();
                    break;
                case '4':
                    subirPatente();
                    break;
                case '5':
                    impressao();
                    break;
                case '6':
                    imprimirHabilitados();
                    break;
                case '7':
                    subirHabilitados();
                    break;
                case '8':
                    impressaoAeronautica();
                    break;
                case '9':
                    impressaoExercito();
                    break;
                case 'A':
                case 'a':
                    impressaoMarinha();
                    break;
                case 'B':
                case 'b':
                    ficar=false;
                    break;
            }
        }while(ficar);
    }

}
