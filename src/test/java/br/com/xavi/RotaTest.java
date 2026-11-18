package br.com.xavi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotaTest {

    @Test
    void deveCriarRotaCorretamente() {
        Rota rota = new Rota(
            Cidade.BELO_HORIZONTE,
            Cidade.RECIFE
        );

        assertNotNull(rota);
    }

    @Test
    void deveRetornarOrigemCorreta() {
        Rota rota = new Rota(
            Cidade.BELO_HORIZONTE,
            Cidade.RECIFE
        );

        assertEquals(Cidade.BELO_HORIZONTE, rota.getOrigem());
    }

    @Test
    void deveRetornarDestinoCorreto() {
        Rota rota = new Rota(
            Cidade.BELO_HORIZONTE,
            Cidade.RECIFE
        );

        assertEquals(Cidade.RECIFE, rota.getDestino());
    }

    @Test
    void deveGerarCodigoCorreto() {
        Rota rota = new Rota(
            Cidade.BELO_HORIZONTE,
            Cidade.RECIFE
        );

        assertEquals("1350", rota.getCodigo());
    }

    @Test
    void deveRetornarToStringCorreto() {
        Rota rota = new Rota(
            Cidade.BELO_HORIZONTE,
            Cidade.RECIFE
        );

        assertEquals(
            "BELO_HORIZONTE -> RECIFE",
            rota.toString()
        );
    }

    @Test
    void naoDeveCriarRotaComOrigemNula() {
        assertThrows(
            NullPointerException.class,
            () -> new Rota(null, Cidade.RECIFE)
        );
    }

    @Test
    void naoDeveCriarRotaComDestinoNulo() {
        assertThrows(
            NullPointerException.class,
            () -> new Rota(Cidade.BELO_HORIZONTE, null)
        );
    }
}