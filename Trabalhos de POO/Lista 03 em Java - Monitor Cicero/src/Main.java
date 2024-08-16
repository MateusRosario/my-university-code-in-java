import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        boolean sair=false;
        Scanner ent = new Scanner(System.in);
        char question;
        System.out.println("Classe Main para testes");
        do{
            System.out.println("\n\nDigite a opção desejada: \n(1)Porta.\n(2)Casa.\n(3)Sair");
            question=ent.next().charAt(0);
           switch (question) {
               case '1':
                        Porta portaDosFundos = new Porta();                 //teste: criando porta.
                        System.out.println("Porta dos fundos criada...");   //Saida.
                        portaDosFundos.abre();                              //teste: abrindo porta.

                        System.out.println("Porta foi aberta...");          //saida.
                        portaDosFundos.fecha();                             //teste. fechando porta.
                        System.out.println("Porta foi fechada...");         //saida.

                        portaDosFundos.pinta("Azul");                   //teste: pintando de Azul.
                        System.out.println("Porta pintada de cor " + portaDosFundos.cor); //saida.
                        portaDosFundos.pinta("Amarela");                //teste: pintando de Amarela.
                        System.out.println("Porta pintada de cor " + portaDosFundos.cor); //saida.
                        portaDosFundos.pinta("Marron");                 //teste: pintando de Marron.
                        System.out.println("Porta pintada de cor " + portaDosFundos.cor); //saida.

                        portaDosFundos.dimensaoX=1.30;  //mudando dimensão X em metros.
                        portaDosFundos.dimensaoY=2;     //mudando dimensão Y em metros.
                        portaDosFundos.dimensaoZ=0.03;  //mudando dimensão Y em metros.

                        if(portaDosFundos.estaAberta()){                //teste: testando se está aberta.
                            System.out.println("Porta está aberta");    //saida se estiver aberta.
                        }else{
                            System.out.println("Porta está fechada");   //saida se estiver fechada.
                        }

                   break;
               case '2':
                        Casa casaNova = new Casa(); //teste: Casa criada.
                        System.out.println("Porta dos fundos criada...");   //saida.

                        casaNova.pinta("Branca");   //teste: casa sendo pintada.
                        System.out.println("Porta pintada de cor " + casaNova.cor); //saida.

                        Porta portaDaFrente = new Porta();
                        portaDaFrente.pinta("Prata");
                        System.out.println("Primeira porta criada.");
                        Porta portaDoQuarto = new Porta();
                        portaDoQuarto.pinta("Vermelha");
                        System.out.println("Segunda porta criada.");
                        Porta portaDoFundo = new Porta();
                        portaDoFundo.pinta("Marron");
                        System.out.println("Terceira porta criada.");

                        casaNova.criarPortas(3);
                        casaNova.colocarPortas(portaDaFrente);
                        casaNova.colocarPortas(portaDoQuarto);
                        casaNova.colocarPortas(portaDoFundo);
                        System.out.println("Portas colocadas na casa...");
                        casaNova.portas[0].abre();
                        casaNova.portas[1].abre();
                        casaNova.portas[2].abre();
                        System.out.println("Abrindo todas as portas");

                        System.out.println("A casa tem " + casaNova.quantasPortasEstaoAbertas() + " portas abertas");   //teste: verificando quantas portas abertas.
                   break;
               case '3':
                   sair=true;
                   break;
           }
        }while(sair!=true);
    }
}
