public class Main {
    public static void main(String[] args) {
        PagamentoService pagamentoService = new PagamentoService();

        try {
            // cadastro de clientes e planos
            Cliente joao = new Cliente("João Silva", "joao@email.com", 25);
            Cliente maria = new Cliente("Maria Souza", "maria@email.com", 30);
            joao.setPlano(new PlanoMensal());
            maria.setPlano(new PlanoPremium());

            // treinos
            joao.adicionarTreino(new Treino("Peito e tríceps", 4, 12));
            joao.adicionarTreino(new Treino("Costas e bíceps", 3, 10));
            maria.adicionarTreino(new Treino("Pernas", 4, 15));

            // exibir informações
            System.out.println(joao);
            for (Treino t : joao.getTreinos()) {
                System.out.println("  Treino: " + t);
            }
            System.out.println(maria);
            for (Treino t : maria.getTreinos()) {
                System.out.println("  Treino: " + t);
            }
            System.out.println();

            // pagamentos
            pagamentoService.processarPagamento(joao);
            System.out.println();
            pagamentoService.processarPagamento(maria);
            System.out.println();

            // polimorfismo: lista de Calculavel
            java.util.List<Calculavel> planos = new java.util.ArrayList<>();
            planos.add(new PlanoMensal());
            planos.add(new PlanoPremium());
            for (Calculavel p : planos) {
                System.out.println("Mensalidade: R$ " + p.calcularMensalidade());
            }
            System.out.println();

            // tratamento de erro
            new Cliente("Pedro", "pedro@email.com", 14);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado no sistema.");
        }
    }
}
