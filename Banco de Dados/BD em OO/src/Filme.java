import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class Filme extends Serie {
    private String Duracao;
    private String Video;

    public Filme(){

    }

    public Filme(int ID, String Nome, int Avaliacao, int Indicacao, String Categoria, String Duracao, String Video){
        super(ID, Nome, Avaliacao, Indicacao, Categoria);
        this.Duracao = Duracao;
        this.Video = Video;
    }

    public static ArrayList<Filme> listarFilmes(ObjectContainer bd){
        ObjectSet result = bd.queryByExample(new Filme());
        ArrayList<Filme> series = new ArrayList<Filme>();
        if(result.size() != 0) {
            for (int i = 0; i < result.size(); i++) {
                series.add((Filme) result.next());
                System.out.println(series.get(i));
            }
            return series;
        }else{
            System.out.println("Nenhum elemento do tipo 'Filme' encontrado.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "ID=" + getID() +
                ", Nome='" + getNome() + '\'' +
                ", Avaliacao=" + getAvaliacao() +
                ", Indicacao=" + getIndicacao() +
                ", Categoria='" + getCategoria() + '\'' +
                ", Duracao='" + Duracao + '\'' +
                ", Video='" + Video + '\'' +
                '}';
    }
}
/*
+void construtor(...);
+void listar(...);
+String toString();
*/