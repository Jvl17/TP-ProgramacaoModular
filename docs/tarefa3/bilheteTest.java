import static org.junit.jupiter.api.Assertions.*;

class BilheteTest {

    private final LocalDate dia = LocalDate.of(2026, 12, 1);

    @Test
    void aceitaVooEncadeado() {
        Bilhete b = new Bilhete(new Cliente());
        b.adicionarVoo(new Voo(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA, dia, 100));
        assertTrue(b.adicionarVoo(new Voo(Cidade.FORTALEZA, Cidade.SAO_LUIS, dia, 200)));
    }

    @Test
    void rejeitaVooQueNaoSaiDoDestinoAnterior() {
        Bilhete b = new Bilhete(new Cliente());
        b.adicionarVoo(new Voo(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA, dia, 100));
        assertFalse(b.adicionarVoo(new Voo(Cidade.RECIFE, Cidade.NATAL, dia, 200)));
    }

    @Test
    void rejeitaVooComDoisDiasDeDiferenca() {
        Bilhete b = new Bilhete(new Cliente());
        b.adicionarVoo(new Voo(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA, dia, 100));
        assertFalse(b.adicionarVoo(new Voo(Cidade.FORTALEZA, Cidade.SAO_LUIS, dia.plusDays(2), 200)));
    }

    @Test
    void precoComDoisVoos() {
        Bilhete b = new Bilhete(new Cliente());
        b.adicionarVoo(new Voo(Cidade.BELO_HORIZONTE, Cidade.FORTALEZA, dia, 100));
        b.adicionarVoo(new Voo(Cidade.FORTALEZA, Cidade.SAO_LUIS, dia, 200));
        assertEquals(160.0, b.calcularPreco(), 0.001);
    }
