import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static int op;
    static HashMap<String, ArvoreBinaria> banco = new HashMap<String, ArvoreBinaria>();
    static List<String> chaves = new ArrayList<>();
    static String nome;
    static ArvoreBinaria selecionada;

    public static void main(String[] args) {
        while(true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("||Arvores (1)||\n||Nova Arvore(2)||\n||Sair (0)||");
            try {
                op = teclado.nextInt();
                switch (op) {
                    case 1:
                        menuArvores();
                        break;
                    case 2:
                        menuNovaArvore();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("|| -> [Opção escolhida Invalida] <- ||");
                        break;
                }
            }catch (Exception e){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("|| -> [Entrada Invalida] <- ||");
                teclado.nextLine();
                teclado.nextLine();
            }
        }
    }

    private static void menuArvores(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(banco.isEmpty()){
            System.out.println("||Não existe arvores criadas||");
            teclado.nextLine();
            teclado.nextLine();
            return;
        }

        while(true){
            System.out.println("||Arvores Existentes||");
            for (int i = 0; i < banco.size() ; i++) {
                System.out.println("||" + chaves.get(i) + " (" + (i+1) + ")||");
            }
            System.out.println("\n||Voltar (0)||");

            try {
                teclado.nextLine();
                op = teclado.nextInt();

                if (op == 0) {
                    return;
                }

                nome = chaves.get(op - 1);
                selecionada = banco.get(nome);

                menuArvore();
                return;
            }catch (Exception e){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("|| -> [Entrada Invalida] <- ||");
                teclado.nextLine();
                teclado.nextLine();
            }
        }
    }

    private static void menuNovaArvore(){
        while(true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("||Inserir Arvore (1)||\n||Criar nova Arvore (2)||\n||Voltar (0)||");
            try {
                op = teclado.nextInt();

                switch (op) {
                    case (1):
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.print("{{Digite o nome da arvore -->");
                        teclado.nextLine();
                        nome = teclado.nextLine();
                        System.out.print("{{Digite a arvore de entrada: Ex: (10(5)(7)) --> ");
                        String ArvoreExistente = teclado.nextLine();
                        selecionada = new ArvoreBinaria(ArvoreExistente);
                        banco.put(nome, selecionada);
                        chaves.add(nome);
                        menuArvore();
                        break;
                    case (2):
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.print("{{Digite o nome da arvore -->");
                        teclado.nextLine();
                        nome = teclado.nextLine();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.print("{{Digite a raiz da sua arvore --> ");
                        int raiz = teclado.nextInt();
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.print("{{Ela será de busca?}} \n||sim (1)||\n||não (2)||\n||--> ");
                        op = teclado.nextInt();

                        if (op == 1) {
                            selecionada = new ArvoreBinaria(true, raiz);
                        } else {
                            selecionada = new ArvoreBinaria(false, raiz);
                        }
                        banco.put(nome, selecionada);
                        chaves.add(nome);
                        menuArvore();
                        break;
                }
                break;
            }catch (Exception e){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("|| -> [Entrada Invalida] <- ||");
                teclado.nextLine();
                teclado.nextLine();
            }
        }
    }

    private static void menuArvore(){
        while (true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("{{Nome: " + nome + "}");
            System.out.println(selecionada.getDeBusca()?"{{Arvore Ordenada Para Busca}":"{{Arvore Não Ordenada para Busca}");
            System.out.println("||Inserir folhas (1)||\n||Imprimir em Pre-Ordem (2)||\n||Imprimir Em-Ordem (3)||\n||Imprimir em Pos-Ordem (4)||\n||Imprimir Caminhos (5)||\n||Voltar (0)||");
            try {
                op = teclado.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\n||Insira as folhas||\n{Para finalizar, digite ( -1 )}");
                        int folha;
                        while (true) {
                            System.out.print("||--> ");
                            folha = teclado.nextInt();
                            if (folha == -1) {
                                break;
                            }
                            selecionada.inserir(folha);
                        }
                        break;
                    case 2:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("||Arvore em Pre-Ordem||");
                        System.out.println("||" + selecionada.printPreOrdem() + "||");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 3:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("||Arvore Em-Ordem||");
                        System.out.println("||" + selecionada.printInOrdem() + "||");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 4:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("||Arvore em Pos-Ordem||");
                        System.out.println("||" + selecionada.printPosOrdem() + "||");
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 5:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("||Todos os Caminhos da Arvore||");
                        List<String> caminhos = selecionada.getCaminhos();
                        for (String item : caminhos) {
                            System.out.println("||" + item + "||");
                        }
                        teclado.nextLine();
                        teclado.nextLine();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("|| -> [Opção escolhida Invalida] <- ||");
                        teclado.nextLine();
                        teclado.nextLine();
                }
            }catch (Exception e){
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("|| -> [Entrada Invalida] <- ||");
                teclado.nextLine();
                teclado.nextLine();
            }
        }
    }
}