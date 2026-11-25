import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * CidadeTest
 */
class CidadeTest {

    @Test 
    void deveExistirTodasAsCidades() {
        assertEquals(6, Cidade.values().length);

        assertNotNull(Cidade.valueOf("BELO_HORIZONTE"));
        assertNotNull(Cidade.valueOf("FORTALEZA"));
        assertNotNull(Cidade.valueOf("RECIFE"));
        assertNotNull(Cidade.valueOf("JOAO_PESSOA"));
        assertNotNull(Cidade.valueOf("SAO_LUIS"));
        assertNotNull(Cidade.valueOf("NATAL"));
    }

    @Test 
    void deveRetornarCodigoDeBeloHorizonte() {
        assertEquals("13", Cidade.BELO_HORIZONTE.getCodigo());
    }

    @Test 
    void deveRetornarCodigoDeRecife(){
        assertEquals("50", Cidade.RECIFE.getCodigo());
    }

    @Test 
    void deveLancarErroParaCidadeSemCodigo() {
        assertThrows(
            IllegalStateException.class,
        () -> Cidade.FORTALEZA.getCodigo()
    );
    }
    
}
