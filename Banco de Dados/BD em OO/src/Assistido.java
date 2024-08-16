import java.util.ArrayList;
import java.util.List;

public class Assistido {

   private int serie;
   private String tempo;
   private int avaliacao;
   private String usuario;

////'construtor'////
   public Assistido(){}

   public Assistido( int serie, String tempo, int avaliacao, String usuario){
       this.serie=serie;
       this.tempo= tempo;
       this.avaliacao=avaliacao;
       this.usuario= usuario;
   }

   ////getters////

   public int serie(){
        return this.serie;
   }

   public String getusuario(){
       return this.usuario;
   }

   ////setters/////

   public void setTempo(String id){
        this.tempo=id;
    }

   //////////////

   public String toString() {
        return "TVSerie{" +
                "  Serie='" + serie + '\'' +
                ", Tempo=" + tempo +
                ", Avaliacao=" + avaliacao +
                ", Usuario='" + usuario + '\''+ '}';
    }
}

/*
+void construtor(...);
+String toString();
*/