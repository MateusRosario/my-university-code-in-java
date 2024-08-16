package Exercicio1;

public abstract class E_mail {
    private String cabecalhoDe;
    private String cabecalhoPara;
    private String cabecalhoAssunto;
    private String saudacaoIni;
    private String corpoMsg;
    private String saudacaoFinal;
    private String NomeRemetente;
    private String NomeDestinatario;
    private String TextoAssunto;
    private String TextoMsg;

    public E_mail(String cabecalhoDe, String cabecalhoPara, String cabecalhoAssunto, String saudacaoIni,  String corpoMsg, String saudacaoFinal){

        this.cabecalhoDe=cabecalhoDe;
        this.cabecalhoPara=cabecalhoPara;
        this.cabecalhoAssunto=cabecalhoAssunto;
        this.saudacaoIni=saudacaoIni;
        this.corpoMsg=corpoMsg;
        this.saudacaoFinal=saudacaoFinal;

    }

    public void setNomeRemetente(String t){
        this.NomeRemetente=t;
    }

    public void setNomeDestinatario(String t){
        this.NomeDestinatario=t;
    }

    public void setTextoAssunto(String t){
        this.TextoAssunto=t;
    }

    public void setTextoMsg(String t){
        this.TextoMsg=t;
    }

    public void Mensagem(){
        System.out.println(cabecalhoDe + NomeRemetente);
        System.out.println(cabecalhoPara + NomeDestinatario);
        System.out.println(cabecalhoAssunto + TextoAssunto + "\n\n");
        System.out.println(saudacaoIni + "\n");
        System.out.println(corpoMsg + TextoMsg + "\n");
        System.out.println(saudacaoFinal);
    }
}
