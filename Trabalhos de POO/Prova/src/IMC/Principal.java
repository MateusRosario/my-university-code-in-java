package IMC;

public class Principal{
    public static void main(String[] args) {
        Atleta atleta1 = new Atleta(80,1.7);
        Atleta atleta2 = new Atleta(120,1.6);
        Atleta atleta3 = new Atleta(73.4,1.86);

        System.out.println("IMC atleta 1: " + atleta1.calculaIdiceMassaCorporal());
        System.out.println("Resultado Final atleta 1: " + atleta1.resultadoFinal());
        System.out.println();
        System.out.println("IMC atleta 2: " + atleta2.calculaIdiceMassaCorporal());
        System.out.println("Resultado Final atleta 2: " + atleta2.resultadoFinal());
        System.out.println();
        System.out.println("IMC atleta 3: " + atleta3.calculaIdiceMassaCorporal());
        System.out.println("Resultado Final atleta 3: " + atleta3.resultadoFinal());
    }
}
