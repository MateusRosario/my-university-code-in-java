import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;

public class POGGERSTV {
    public static void main(String[] args) {
        ObjectContainer bd = Db4o.openFile("BD.yap");
        //Testes{
        try {
            //Filme a = new Filme(2, "A Pegada", 3, 18, "Ficção Ciêntifica", "2:00:00", "A Chegada.mp3");
            //a.salvar(bd);
            //Serie.listar(bd);
            //System.out.println("--------------");
            //Serie.deletar(bd,3);
            //System.out.println("--------------");
            //Serie.listar(bd);

            //TVSerie b = new TVSerie(4, "WestWord", 5, 18, "Ficção Ciêntifica", 50);
            //b.inserirEpisodeo(1, "00:20:00", "Aquele em que...", "Blabla", "VideoF.mp4");
            //b.inserirEpisodeo(2, "00:23:00", "Aquele em que bla...", "Bleble", "VideoF2.mp4");
            //b.salvar(bd);

            //TVSerie.listar(bd);

            //Usuario c = new Usuario(19, "mateus@gmail.com", "Mateus Rosario", "12345", 'M');
            //Usuario d = new Usuario(19, "matheus@gmail.com", "Matheus Almeida", "54321", 'M');
            //c.salvar(bd);
            //d.salvar(bd);

            //Usuario.listar(bd);
        } catch (Exception e) {
            System.out.println(e);
        }
        //}
        bd.close();
    }

    public static List<Serie> getMaiorQue(ObjectContainer bd, int x){
        List<Serie> series = Serie.listar(bd);
        List<Serie> result = new ArrayList<Serie>();
        for (int i = 0; i < series.size() ; i++) {
            if(series.get(i).getAvaliacao() > x){
                System.out.println(series.get(i));
                result.add(series.get(i));
            }
        }
        return result;
    }

    public static List<Usuario> getAssistidoPor(ObjectContainer bd, String email){
        Usuario a = Usuario.recuperar(bd, email);
        for (int i = 0; i < a.assistidos.size() ; i++) {
            System.out.println(a.assistidos.get(i));
        }
        return a.assistidos;
    }

    public static List<Serie> getSerieDsCategoria(ObjectContainer bd, String x){
        List<Serie> series = Serie.listar(bd);
        List<Serie> result = new ArrayList<Serie>();
        for (int i = 0; i < series.size() ; i++) {
            if(series.get(i).getCategoria().contains(x)){
                System.out.println(series.get(i));
                result.add(series.get(i));
            }
        }
        return result;
    }
}