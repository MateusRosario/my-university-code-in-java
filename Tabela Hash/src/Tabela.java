public class Tabela {
    private Aluno[] alunos;
    private int m;

    public Tabela(int tam){
        alunos = new Aluno[tam];
        m = tam;
    }

    public void inserir(Aluno aluno){
        int key = aluno.getKey(m);
        if(alunos[key] == null){
            alunos[key] = aluno;
        }else{
            alunos[key].inserirProximo(aluno);
        }
    }

    public Aluno Busca(String nome){
        int soma = 0;
        for (int i = 0; i < nome.length(); i++) {
            soma += nome.charAt(i);
        }
        soma = (soma % m);
        if(alunos[soma] != null) {
            return Busca(alunos[soma], nome);
        }else{
            return null;
        }
    }

    private Aluno Busca(Aluno aluno,String nome){
        if(aluno.getNome().equals(nome)){
            return aluno;
        }else{
            if(aluno.getProximo() != null) {
                return Busca(aluno.getProximo(), nome);
            }else{
                return null;
            }
        }
    }
}