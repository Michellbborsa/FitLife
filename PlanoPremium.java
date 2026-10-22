public class PlanoPremium extends Plano {
    public PlanoPremium() {
        super("Premium", 200.0);
    }

    @Override
    public double calcularMensalidade() {
        return valorBase + 50.0;
    }
}
