import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {

    private String email;
    private int idade;
    private String nome;
    private char sexo;
    private String senha;
    List assistidos = new ArrayList();

    ///////'contrutor'//////

    public Usuario(){}

    public Usuario(int idade, String email, String nome, String senha, char s){
        this.idade = idade;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.sexo = s;
        this.assistidos.addAll(Arrays.asList(assistidos));
    }

    ///////getters/////

    public int getidade(){
        return this.idade;
    }

    public String getemail(){
        return this.email;
    }

    public String getnome(){
        return this.nome;
    }

    public char getsexo(){
        return this.sexo;
    }

    ////setters////

    public void setEmail(String email){
        this.email=email;
    }

    /////////////////

    public boolean inserirAssistido( int serie, String tempo, int avaliacao, String usuario){

        Assistido a = new Assistido(serie,tempo,avaliacao,usuario);
        assistidos.add(a);

         return true;
    }

    public boolean deletarAssistido(int serie){
        Assistido a = new Assistido();

        //for (int i = 0; i <assistidos.size() ; i++) {
        //    a.getid()==assistidos.get
        //}
      //
        return true;
    }

    public void salvar (ObjectContainer bd){
        bd.store(this);
    }

    public static Usuario recuperar(ObjectContainer bd, String email){
        Usuario a = new Usuario();
        a.setEmail(email);
        ObjectSet result = bd.queryByExample(a);
        if(result.size() != 0) {
            Usuario b = (Usuario) result.next();
            System.out.println(b);
            return b;
        }else{
            System.out.println("Usuario não encontrado.");
            return null;
        }
    }

    public static void listar(ObjectContainer bd){
        ObjectSet result = bd.queryByExample(new Usuario());
        if(result.size() != 0) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println((Usuario) result.next());
            }
        }else{
            System.out.println("Nenhum elemento do tipo 'Usuario' encontrado.");
        }
    }

    public static void deletar (ObjectContainer bd, String email){
        Usuario u = new Usuario();
        u.setEmail(email);

        ObjectSet result = bd.queryByExample(new Usuario());
        Usuario busca[] = new Usuario[result.size()];

        for (int i = 0; i <result.size() ; i++) {
            busca[i]= (Usuario)result.next();
                if (u.getemail().equals(busca[i].email)){
                    bd.delete(busca[i]);
                    break;
                }
        }
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "email='" + email + '\'' +
                ", idade=" + idade +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", senha='" + senha + '\'' +
                ", assistidos=" + assistidos +
                '}';
    }
}
/*
+void construtor(...);
+String getEmail();
+void setEmail(String email);
+boolean inserirAssistido(...);
+boolean deletarAssistido(int serie);
+void salvar(...);
+void listar(...);
+Serie recuperar(...);
+void deletar(...);
+String toString();
*/