package ex2;

import java.io.Serializable;
import java.util.Scanner;

public class Quadrilatero implements Serializable {
    public static int INVALIDO = 0;
    public static int RETANGULO = 1;
    public static int QUADRADO = 2;
    public static int QUADRILATERO = 3;

    private double lado1;
    private double lado2;
    private double lado3;
    private double lado4;
    private int tipo;

    public void leDados(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" -------------------------------------------------------------------------------------- ");
        System.out.println("Digite tamanho do lado 1: ");
        this.lado1 = scanner.nextDouble();
        System.out.println("Digite tamanho do lado 2: ");
        this.lado2 = scanner.nextDouble();
        System.out.println("Digite tamanho do lado 3: ");
        this.lado3 = scanner.nextDouble();
        System.out.println("Digite tamanho do lado 4: ");
        this.lado4 = scanner.nextDouble();
        System.out.println(" -------------------------------------------------------------------------------------- ");
    }

    public int indicaTipoDeQuadrilatero(){
        if(lado1 == 0.0){
            this.tipo = Quadrilatero.INVALIDO;
            return this.tipo;
        }

        if(lado1 == lado2 && lado2 == lado3 && lado3 == lado4){
            this.tipo = Quadrilatero.QUADRADO;
            return this.tipo;
        }

        if(lado1 == lado3 && lado2 == lado4){
            this.tipo = Quadrilatero.RETANGULO;
            return this.tipo;
        }

        this.tipo = Quadrilatero.QUADRILATERO;
        return this.tipo;
    }

    public void mostraDados(){
        System.out.println(" -------------------------------------------------------------------------------------- ");
        System.out.println("Quadrilatero do tipo: " + this.getTipo());
        System.out.println("Dimensões: " + this.lado1 + "|" + this.lado2 + "|" + this.lado3 + "|" + this.lado4);
        System.out.println(" -------------------------------------------------------------------------------------- ");
    }

    public String getTipo() {
        if(tipo == Quadrilatero.INVALIDO){
            return "Invalido";
        }

        if(tipo == Quadrilatero.RETANGULO){
            return "Retângulo";
        }

        if(tipo == Quadrilatero.QUADRADO){
            return "Quadrado";
        }

        if(tipo == Quadrilatero.QUADRILATERO){
            return "Quadrilátero";
        }
        return "Invalido";
    }
}
