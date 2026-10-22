// treino que pertence a um cliente
public class Treino {
    private String nome;
    private int series;
    private int repeticoes;

    public Treino(String nome, int series, int repeticoes) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do treino é obrigatório!");
        }
        if (series <= 0 || repeticoes <= 0) {
            throw new IllegalArgumentException("Séries e repetições devem ser maiores que zero!");
        }
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() { return nome; }
    public int getSeries() { return series; }
    public int getRepeticoes() { return repeticoes; }

    @Override
    public String toString() {
        return nome + " - " + series + "x" + repeticoes;
    }
}
