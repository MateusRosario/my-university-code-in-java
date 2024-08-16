import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Serie {

    private int ID;
    private String Nome;
    private int Avaliacao;
    private int Indicacao;
    private String Categoria;

    public Serie(){
    }

    public Serie(int ID, String Nome, int Avaliacao, int Indicacao, String Categoria){
        this.ID = ID;
        this.Nome = Nome;
        this.Avaliacao = Avaliacao;
        this.Indicacao = Indicacao;
        this.Categoria = Categoria;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public int getAvaliacao() {
        return Avaliacao;
    }

    public int getIndicacao() {
        return Indicacao;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void salvar(ObjectContainer bd){
        bd.store(this);
        System.out.println("Serie " + this.getNome() + " foi salvada.");
    }

    public static ArrayList<Serie> listar(ObjectContainer bd){
        ObjectSet result = bd.queryByExample(new Serie());
        ArrayList<Serie> series = new ArrayList<Serie>();
        if(result.size() != 0) {
            for (int i = 0; i < result.size(); i++) {
                series.add((Serie) result.next());
                System.out.println(series.get(i));
            }
            return series;
        }else{
            System.out.println("Nenhum elemento do tipo 'Serie' encontrado.");
            return null;
        }
    }

    public static Serie recuperar(ObjectContainer bd, int ID){
        Serie a = new Serie();
        a.setID(ID);
        ObjectSet result = bd.queryByExample(a);
        if(result.size() != 0) {
            Serie b = (Serie) result.next();
            System.out.println(b);
            return b;
        }else{
            System.out.println("ID não encontrado.");
            return null;
        }
    }

    public static void deletar(ObjectContainer bd, int ID){
        Serie a = new Serie();
        a.setID(ID);
        ObjectSet result = bd.queryByExample(a);
        if(result.size() != 0) {
            a = (Serie) result.next();
            bd.delete(a);
            System.out.println("Serie " + a.getNome() + " deletada.");
        }else{
            System.out.println("ID não encontrado.");
        }
    }

    public void substituir(ObjectContainer bd){
        Serie a = new Serie();
        a.setID(ID);
        ObjectSet result = bd.queryByExample(a);
        if(result.size() != 0) {
            a = (Serie) result.next();
            bd.delete(a);
            bd.store(this);
            System.out.println("Serie " + a.getNome() + " substituida.");
        }else{
            System.out.println("ID não encontrado.");
        }
    }

    @Override
    public String toString() {
        return "Serie{" +
                "ID=" + ID +
                ", Nome='" + Nome + '\'' +
                ", Avaliacao=" + Avaliacao +
                ", Indicacao=" + Indicacao +
                ", Categoria='" + Categoria + '\'' +
                '}';
    }
}
/*
+void construtor(...);
+void setID(int ID);
+int getID();
+String getNome();
+int getAvaliacao();
+int getIndicacao();
+String getCategoria();
+void salvar(...);
+void listar(...);
+Serie recuperar(...);
+void deletar(...);
+void substituir(...);
+String toString();
*/