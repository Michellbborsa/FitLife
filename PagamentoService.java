public class PagamentoService {
    public void processarPagamento(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido!");
        }
        if (cliente.getPlano() == null) {
            throw new IllegalStateException("Cliente não possui plano!");
        }
        double valor = cliente.getPlano().calcularMensalidade();
        System.out.println("Processando pagamento...");
        System.out.printf("Cliente: %s%n", cliente.getNome());
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Pagamento realizado com sucesso!");
    }
}
