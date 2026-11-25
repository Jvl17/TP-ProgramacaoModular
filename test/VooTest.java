import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class VooTest {

    private final Rota rota = new Rota(Cidade.BELO_HORIZONTE, Cidade.RECIFE);
    private final LocalDate data = LocalDate.of(2026, 12, 10);

    @Test
    void deveCriarVooCorretamente() {
        Voo voo = new Voo(rota, data, 500);

        assertEquals(rota, voo.getRota());
        assertEquals(data, voo.getData());
        assertEquals(500, voo.getPrecoBase(), 0.001);
    }

    @Test
    void capacidadeMaximaDeveSer150() {
        assertEquals(150, Voo.CAPACIDADE_MAXIMA);
    }

    @Test
    void naoDeveCriarVooSemRota() {
        assertThrows(IllegalArgumentException.class, () -> new Voo(null, data, 500));
    }

    @Test
    void naoDeveCriarVooSemData() {
        assertThrows(IllegalArgumentException.class, () -> new Voo(rota, null, 500));
    }

    @Test
    void naoDeveCriarVooComPrecoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Voo(rota, data, 0));
    }

    @Test
    void naoDeveCriarVooComPrecoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Voo(rota, data, -100));
    }

    @Test
    void deveAlterarPrecoBase() {
        Voo voo = new Voo(rota, data, 500);
        voo.setPrecoBase(750);

        assertEquals(750, voo.getPrecoBase(), 0.001);
    }

    @Test
    void naoDeveAlterarPrecoBaseParaValorInvalido() {
        Voo voo = new Voo(rota, data, 500);

        assertThrows(IllegalArgumentException.class, () -> voo.setPrecoBase(0));
        assertEquals(500, voo.getPrecoBase(), 0.001);
    }
}
