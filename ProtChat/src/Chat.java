import java.io.IOException;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Chat {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

    public Usuario novoUser(String user, Socket conexao) {
        for (Usuario a: usuarios) {
            if(a.getUser().equals(user)){
                return null;
            }
        }
        Usuario usuario = new Usuario(user, conexao);
        usuarios.add(usuario);
        return usuario;
    }

    public void novaMensagem(String user, Date data, String texto){
        Mensagem nova = new Mensagem(user,data, texto);
        mensagens.add(nova);
        System.out.println("Nova Mensagem{ Usuario: " + user + "; Mensagem:\n" + texto + "\n}\n");

        String mensagem = "[" + formatarData(data) + "] " + user + ":\n" + texto + "\n";

        for ( Usuario a: usuarios) {
            if(!a.getUser().equals(user)){
                try {
                    a.update(mensagem);
                }catch (IOException e){
                    System.out.println("\"Erro\": Envio de Mensagem para " + a.getUser() + " falhou.");
                }
            }
        }
    }

    public String formatarData(Date data){
        return data.getDay() + "/" + data.getMonth() + "/" + data.getYear() + " as " + data.getHours() + ":" + data.getMinutes();
    }
}
