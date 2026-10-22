// classe abstrata: base para todos os planos
public abstract class Plano implements Calculavel {
    protected String nome;
    protected double valorBase;

    public Plano(String nome, double valorBase) {
        this.nome = nome;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public abstract double calcularMensalidade();
}
