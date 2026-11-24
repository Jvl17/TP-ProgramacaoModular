package br.com.xavi;

// Agente utilizado: Claude Opus 5.5

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ClienteTest {

    private Bilhete criarBilhete(double preco) {
        Rota rota = new Rota(Cidade.BELO_HORIZONTE, Cidade.RECIFE);
        Voo voo = new Voo(rota, LocalDate.of(2026, 12, 10), preco);
        Bilhete bilhete = new Bilhete();
        bilhete.adicionarVoo(voo);
        return bilhete;
    }

    @Test
    void deveCriarClienteCorretamente() {
        Cliente cliente = new Cliente("Caio", "Mayllart", 1);

        assertEquals("Caio", cliente.getNome());
        assertEquals("Mayllart", cliente.getSobrenome());
        assertEquals(1, cliente.getNumeroRegistro());
        assertEquals(0, cliente.getBilhetes().size());
    }

    @Test
    void naoDeveCriarClienteSemNome() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("", "Mayllart", 1));
    }

    @Test
    void naoDeveCriarClienteSemSobrenome() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Caio", "", 1));
    }

    @Test
    void naoDeveCriarClienteComRegistroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("Caio", "Mayllart", 0));
    }

    @Test
    void deveAdicionarBilhete() {
        Cliente cliente = new Cliente("Caio", "Mayllart", 1);
        cliente.addBilhete(criarBilhete(500));

        assertEquals(1, cliente.getBilhetes().size());
    }

    @Test
    void naoDeveAdicionarBilheteNulo() {
        Cliente cliente = new Cliente("Caio", "Mayllart", 1);

        assertThrows(IllegalArgumentException.class, () -> cliente.addBilhete(null));
    }

    @Test
    void totalSemBilhetesDeveSerZero() {
        Cliente cliente = new Cliente("Caio", "Mayllart", 1);

        assertEquals(0, cliente.getTotal());
    }

    @Test
    void totalDeveSomarOsBilhetes() {
        Cliente cliente = new Cliente("Caio", "Mayllart", 1);
        cliente.addBilhete(criarBilhete(500));
        cliente.addBilhete(criarBilhete(300));

        assertEquals(800, cliente.getTotal(), 0.01);
    }
}
