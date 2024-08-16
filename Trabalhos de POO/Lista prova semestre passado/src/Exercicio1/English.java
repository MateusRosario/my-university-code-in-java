package Exercicio1;

public class English extends E_mail {

    public English() {
        super("From: ", "To: ", "Subject: ", "Dear Student, ", "I write this mesage in order to ... ", "Sincelery,\nProfessor");
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
