import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        Scanner a = new Scanner(System.in);
        Tabela tabela = new Tabela(31);
        ModuloTeste(tabela);
        do {
            System.out.println("==================================");
            System.out.println("|Menu|\n");
            System.out.println("|(1) - Inserir|");
            System.out.println("|(2) - Buscar|");
            System.out.println("|(3) - Sair|");
            System.out.println("==================================");
            int ent = a.nextInt();
            a.nextLine();
            String Nome;
            switch (ent) {
                case 1:
                    System.out.println("Curso:");
                    String curso = a.next();
                    System.out.println("Numero:");
                    int Numero = a.nextInt();
                    a.nextLine();
                    System.out.println("Nome:");
                    Nome = a.nextLine();
                    System.out.println("Matricula:");
                    String Matricula = a.next();
                    tabela.inserir(new Aluno(curso, Numero, Nome, Matricula));
                    break;
                case 2:
                    System.out.println("Nome:");
                    Nome = a.nextLine();
                    Aluno result = tabela.Busca(Nome);
                    if (result == null) {
                        System.out.println("Aluno não Encontrado");
                    } else {
                        System.out.println("===========================");
                        System.out.println("Curso: " + result.getCurso());
                        System.out.println("Número: " + result.getNum());
                        System.out.println("Nome: " + result.getNome());
                        System.out.println("Matrícula: " + result.getMatricula());
                        System.out.println("===========================");
                    }
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }while (continuar);
    }

    public static void ModuloTeste(Tabela tabela) {
        tabela.inserir(new Aluno("06I500B", 1, "Alexandre Lima Valdivino", "2008115120"));
        tabela.inserir(new Aluno("06I500B", 2, "Bruno Bandeira Fernandes", "2010212972"));
        tabela.inserir(new Aluno("06I500B", 4, "Chester Winner Milhomem Ara", "2008217763"));
        tabela.inserir(new Aluno("06I500B", 5, "Clazzeani Dias Almeida", "2008217709"));
        tabela.inserir(new Aluno("06I500B", 6, "Dábila Cristina dos Santos", "2010111407"));
        tabela.inserir(new Aluno("06I500B", 7, "Diogenes Cortez Morais", "2009215048"));
        tabela.inserir(new Aluno("06I500B", 8, "Dionízio Oliveira Bastos Ne", "2010212737"));
        tabela.inserir(new Aluno("06I500B", 9, "Fabio Henrique Rizzi Brune", "2008216750"));
        tabela.inserir(new Aluno("06I500B", 10, "Frederico da Silva Santos", "2010213054"));
        tabela.inserir(new Aluno("06I500B", 11, "Hemmerson Luis Barros da Ro", "2009116776"));
        tabela.inserir(new Aluno("06I500B", 12, "Herinson Barbosa Rodrigues", "2010212475"));
        tabela.inserir(new Aluno("06I500B", 13, "Kaio Mazilles Dantas de Med", "2009116735"));
        tabela.inserir(new Aluno("06I500B", 14, "Laís Rodrigues Barros", "2010212728"));
        tabela.inserir(new Aluno("06I500B", 15, "Lázaro Souza Duarte", "2011111335"));
        tabela.inserir(new Aluno("06I500B", 16, "Marcelo Cobias Amorim Alves", "2010110582"));
        tabela.inserir(new Aluno("06I500B", 17, "Marcos Raylan Sousa Matos", "2010212944"));
        tabela.inserir(new Aluno("06I500B", 18, "Maurício Takeshi Maki", "2008217610"));
        tabela.inserir(new Aluno("06I500B", 19, "Patrick do Nascimento Barbo", "2007225773"));
        tabela.inserir(new Aluno("06I500B", 20 ,"Pedro Júnior Ferreira de So", "2009214912"));
        tabela.inserir(new Aluno("06I500B", 21, "Rodrigo Cordeiro Dias", "2009219839"));
        tabela.inserir(new Aluno("06I500B", 22,"Rodrigo Santiago da Costa", "2010213300"));
        tabela.inserir(new Aluno("06I500B", 23, "Saulo Pires de Souza" ,"2009214923"));
        tabela.inserir(new Aluno("06I500B", 24, "Sávio Soares Dias", "2010212845"));
        tabela.inserir(new Aluno("06I500B", 25, "Thalles Natan Gonçalves", "2009116738"));
        tabela.inserir(new Aluno("06I500B", 26, "Tito Albino Evangelista da" ,"2008216751"));
        tabela.inserir(new Aluno("06I500B", 27, "Valéria Martins da Silva", "2010213174"));
        tabela.inserir(new Aluno("06I500B", 28, "Waléria Esteffany Laurindo" ,"2010213405"));
        tabela.inserir(new Aluno("06I500B", 29, "Werlem Henrique Rodrigues I" ,"2009116756"));
    }
}
