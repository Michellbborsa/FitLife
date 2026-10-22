import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private int idade;
    private Plano plano;                        // associação
    private List<Treino> treinos = new ArrayList<>();  // composição

    public Cliente(String nome, String email, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório!");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("E-mail inválido!");
        }
        if (idade < 15) {
            throw new IllegalArgumentException("Idade mínima é 15 anos!");
        }
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public int getIdade() { return idade; }
    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }
    public List<Treino> getTreinos() { return treinos; }

    public void adicionarTreino(Treino treino) {
        if (treino == null) {
            throw new IllegalArgumentException("Treino inválido!");
        }
        treinos.add(treino);
    }

    @Override
    public String toString() {
        String nomePlano = (plano == null) ? "sem plano" : plano.getNome();
        return "Cliente: " + nome + " | " + email + " | " + idade + " anos | Plano: " + nomePlano;
    }
}
