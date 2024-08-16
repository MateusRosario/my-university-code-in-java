import java.time.Duration;

public class Episodeo {
    int numEpisodeo;
    String Duracao;
    String Titulo;
    String Descricao;
    String Video;

    public Episodeo(){
    }

    public Episodeo( int numEpisodeo, String Duracao, String Titulo, String Descricao, String Video){
        this.numEpisodeo = numEpisodeo;
        this.Duracao = Duracao;
        this.Titulo = Titulo;
        this.Descricao = Descricao;
        this.Video = Video;
    }

    public int getNumEpisodeo() {
        return numEpisodeo;
    }

    @Override
    public String toString() {
        return "Episodeo{" +
                "numEpisodeo=" + numEpisodeo +
                ", Duracao='" + Duracao + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", Descricao='" + Descricao + '\'' +
                ", Video='" + Video + '\'' +
                '}';
    }
}
/*
+void construtor(...);
+int getNumEpisodeo();
+String toString();
*/