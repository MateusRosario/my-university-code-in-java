import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;
import java.util.List;

public class TVSerie extends Serie {
    private int QtdEpisodeos;
    List<Episodeo> episodeos = new ArrayList<Episodeo>();

    public TVSerie(){

    }

    public TVSerie(int ID, String Nome, int Avaliacao, int Indicacao, String Categoria, int QtdEpisodeos){
        super(ID, Nome, Avaliacao, Indicacao, Categoria);
        this.QtdEpisodeos = QtdEpisodeos;
    }

    public boolean inserirEpisodeo( int numEpisodeo, String Duracao, String Titulo, String Descricao,String Video){
        for (Episodeo episodeo : episodeos) {
            if (episodeo.getNumEpisodeo() == numEpisodeo) {
                System.out.println("Episodeo já existente");
                return false;
            }
        }
        Episodeo e = new Episodeo(numEpisodeo, Duracao, Descricao, Titulo, Video);
        episodeos.add(e);
        return true;
    }

    public boolean deletarEpisodeo(int numEpisodeo){
        for (Episodeo episodeo : episodeos) {
            if (episodeo.getNumEpisodeo() == numEpisodeo) {
                episodeos.remove(episodeo);
                return true;
            }
        }
        return false;
    }

    public static ArrayList<TVSerie> listarTVSeries(ObjectContainer bd){
        ObjectSet result = bd.queryByExample(new TVSerie());
        ArrayList<TVSerie> series = new ArrayList<TVSerie>();
        if(result.size() != 0) {
            for (int i = 0; i < result.size(); i++) {
                series.add((TVSerie) result.next());
                System.out.println(series.get(i));
            }
        }else{
            System.out.println("Nenhum elemento do tipo 'Filme' encontrado.");
        }
        return null;
    }

    @Override
    public String toString() {
        return "TVSerie{" +
                "ID=" + getID() +
                ", Nome='" + getNome() + '\'' +
                ", Avaliacao=" + getAvaliacao() +
                ", Indicacao=" + getIndicacao() +
                ", Categoria='" + getCategoria() + '\'' +
                ", QtdEpisodeos=" + QtdEpisodeos +
                ", episodeos=" + episodeos +
                '}';
    }
}
/*
+void construtor(...);
+boolean inserirEpisodeo(...);
+boolean deletarEpisodeo(int numEpisodeo);
+void listar(...);
+String toString();
*/