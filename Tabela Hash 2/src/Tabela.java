public class Tabela {
    private Aluno[] alunos;
    private int m;

    public Tabela(int tam){
        alunos = new Aluno[tam];
        m = tam;
    }

    public void inserir(Aluno aluno){
        int hash = aluno.getKey() % m;
        if(alunos[hash] == null){
            alunos[hash] = aluno;
        }else{
            int Dhash = (hash + (2 + (aluno.getKey() % (m-2)))) % m;
            if(alunos[Dhash] == null) {
                alunos[Dhash] = aluno;
            }else{
                alunos[Dhash].inserirProximo(aluno);
            }
        }
    }

    public Aluno Busca(String nome){
        int hash = getKey(nome);
        hash = (hash % m);
        if(alunos[hash] != null) {
            Aluno result = Busca(alunos[hash], nome);
            if(result == null){
                int Dhash = (hash + (2 + (getKey(nome) % (m-2)))) % m;
                return Busca(alunos[Dhash], nome);
            }else{
                return result;
            }
        }else{
            return null;
        }
    }

    private Aluno Busca(Aluno aluno, String nome){
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

    private int getKey(String nome){
        return nome.charAt(0) + nome.charAt(1)*53 + nome.charAt(2)*(53*53);
    }
}