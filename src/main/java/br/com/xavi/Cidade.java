package br.com.xavi;

public enum Cidade {

    BELO_HORIZONTE("13"),
    FORTALEZA(null),
    RECIFE("50"),
    JOAO_PESSOA(null),
    SAO_LUIS(null),
    NATAL(null);

    private final String codigo;

    Cidade(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        if (codigo == null) {
            throw new IllegalStateException(
                "O código da cidade " + this.name() + " ainda não foi definido."
            );
        }

        return codigo;
    }
}
