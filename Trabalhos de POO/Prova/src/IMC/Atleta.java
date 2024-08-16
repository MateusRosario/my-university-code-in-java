package IMC;

public class Atleta {
    private double peso;
    private double altura;

    public Atleta(double peso, double altura){
        this.peso=peso;
        this.altura=altura;
    }

    public double calculaIdiceMassaCorporal(){
        return peso/(altura * altura);
    }

    public String resultadoFinal(){
        double massaCorporal = calculaIdiceMassaCorporal();
        if(massaCorporal<16){
            return "Baixo peso muito grave";
        }else if(massaCorporal<=16.99){
            return "Baixo peso grave";
        }else if(massaCorporal<=18.49){
            return "Baixo peso";
        }else if(massaCorporal<=24.99){
            return "Peso normal";
        }else if(massaCorporal<=29.99){
            return "Sobrepeso";
        }else if(massaCorporal<=34.99){
            return "Obesidade grau I";
        }else if(massaCorporal<=39.99){
            return "Obesidade grau II";
        }else{
            return "Obesidade grau III(obesidade mórbida)";
        }
    }
}
