public class Aluno {
    private String curso;
    private int num;
    private String nome;
    private String matricula;
    private Aluno proximo = null;

    public Aluno(String curso, int num, String nome, String matricula){
        this.curso = curso;
        this.num = num;
        this.nome = nome;
        this.matricula = matricula;
    }

    public void inserirProximo(Aluno aluno){
        if(proximo == null){
            this.proximo = aluno;
        }else{
            this.proximo.inserirProximo(aluno);
        }

    }

    public int getKey(){
        int key = nome.charAt(0) + nome.charAt(1)*53 + nome.charAt(2)*(53*53);
        return key;
    }

    public String getNome() {
        return nome;
    }

    public Aluno getProximo() {
        return proximo;
    }

    public String getCurso() {
        return curso;
    }

    public int getNum() {
        return num;
    }

    public String getMatricula() {
        return matricula;
    }
}