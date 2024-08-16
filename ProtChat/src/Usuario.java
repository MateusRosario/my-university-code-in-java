import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Usuario {
    private String user;
    private Socket conexao;

    public Usuario(String user, Socket conexao){
        this.user = user;
        this.conexao = conexao;
    }

    public String getUser() {
        return user;
    }

    public Socket getConexao() {
        return conexao;
    }

    public void update(String texto) throws IOException {
        OutputStream resposta = conexao.getOutputStream();
        resposta.write(texto.getBytes());
        resposta.flush();
    }
}
