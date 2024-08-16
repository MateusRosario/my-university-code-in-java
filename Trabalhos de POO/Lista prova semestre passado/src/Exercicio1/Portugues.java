package Exercicio1;

public class Portugues extends E_mail {
    public Portugues() {
        super("De: ","Para: ","Assunto: ","Querido(a) Aluno, ","Escrevo esta Mensagem para ... ","Sinceramente,\nProfessor");
    }

    @Override
    public void setNomeRemetente(String t) {
        super.setNomeRemetente(t);
    }

    @Override
    public void setNomeDestinatario(String t) {
        super.setNomeDestinatario(t);
    }

    @Override
    public void setTextoAssunto(String t) {
        super.setTextoAssunto(t);
    }

    @Override
    public void setTextoMsg(String t) {
        super.setTextoMsg(t);
    }

    @Override
    public void Mensagem() {
        super.Mensagem();
    }
}
