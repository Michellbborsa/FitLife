import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FitLifeTest {

    @Test
    public void deveCalcularMensalidadeMensal() {
        Plano plano = new PlanoMensal();
        assertEquals(100.0, plano.calcularMensalidade());
    }

    @Test
    public void deveCalcularMensalidadePremium() {
        Plano plano = new PlanoPremium();
        assertEquals(250.0, plano.calcularMensalidade());
    }

    @Test
    public void naoDeveCadastrarClienteMenorDeIdade() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("João", "joao@email.com", 14);
        });
    }

    @Test
    public void naoDeveCadastrarEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("João", "email-invalido", 20);
        });
    }

    @Test
    public void naoDeveCadastrarNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(" ", "joao@email.com", 20);
        });
    }

    @Test
    public void deveAdicionarTreino() {
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        cliente.adicionarTreino(new Treino("Pernas", 4, 12));
        assertEquals(1, cliente.getTreinos().size());
    }

    @Test
    public void naoDeveProcessarPagamentoDeClienteNulo() {
        PagamentoService service = new PagamentoService();
        assertThrows(IllegalArgumentException.class, () -> service.processarPagamento(null));
    }

    @Test
    public void naoDeveProcessarPagamentoSemPlano() {
        PagamentoService service = new PagamentoService();
        Cliente cliente = new Cliente("João", "joao@email.com", 20);
        assertThrows(IllegalStateException.class, () -> service.processarPagamento(cliente));
    }
}
