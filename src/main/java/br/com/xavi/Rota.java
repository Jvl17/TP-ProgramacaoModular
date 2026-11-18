package br.com.xavi;

import java.util.Objects;

public class Rota {

    private final Cidade origem;
    private final Cidade destino;

    public Rota(Cidade origem, Cidade destino) {
        this.origem = Objects.requireNonNull(origem);
        this.destino = Objects.requireNonNull(destino);
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public String getCodigo() {
        return origem.getCodigo() + destino.getCodigo();
    }

    @Override 
    public String toString() {
        return origem + " -> " + destino;
    }
}
