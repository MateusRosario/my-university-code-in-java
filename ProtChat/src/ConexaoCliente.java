import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoCliente implements Runnable{
    private Socket conexao;
    private boolean conectado;
    private Chat chat;
    private Usuario usuario;

    public ConexaoCliente(Socket conexao, Chat chat){
        this.conexao = conexao;
        this.chat = chat;
        System.out.println("Cliente " + conexao.getInetAddress() + " conectado...") ;
    }

    @Override
    public void run() {
        conectado = true;
        while (conectado) {
            try {
                lerComando(conexao.getInputStream());

            } catch (IOException e) {
                if (e instanceof SocketTimeoutException) {
                    try {
                        conectado = false;
                        this.conexao.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        }
    }

    public void lerComando(InputStream requisicao) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(requisicao));
        String linha = buffer.readLine();
        String[] comandos = linha.split(" ");
        String pedido = comandos[0];

        if(pedido.equals("Entrar")){
            conectarCliente(comandos[1]);
            //"Entrar User"
        }else{
            linha = buffer.readLine();
            String texto = "";
            while (!linha.isEmpty()){
                texto = texto + linha + "\n";
                linha = buffer.readLine();
            }
            sendMensagem(texto);
            //"Mandar User \n text"
        }
    }

    public void conectarCliente(String user) throws IOException {
        usuario = chat.novoUser(user, conexao);
        if(usuario != null){
            System.out.println("Usuario " + user + " entrou na Conversa.");
            responder("Entrar Aceito " + user + "\n");
        }else{
            System.out.println("Cliente " + conexao.getInetAddress() + " tentou logar como " + user + " mas foi negado.");
            responder("Entrar Negado User_Ja_Existente\n");
        }
    }

    public void sendMensagem(String texto){
        chat.novaMensagem(usuario.getUser(), new Date(), texto);
    }

    public void responder(String texto) throws IOException{
        OutputStream resposta = conexao.getOutputStream();
        resposta.write(texto.getBytes());
        resposta.flush();
    }
}