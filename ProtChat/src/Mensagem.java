import java.sql.Time;
import java.util.Date;

public class Mensagem {
    private String user;
    private Date data;
    private String texto;

    public Mensagem(String user, Date data, String texto) {
        this.user = user;
        this.data = data;
        this.texto = texto;
    }

    public String getUser() {
        return user;
    }

    public Date getData() {
        return data;
    }

    public String getTexto() {
        return texto;
    }
}
