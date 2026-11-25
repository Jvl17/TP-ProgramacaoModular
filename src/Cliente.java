// Agente utilizado: Claude Opus 5.5 

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String sobrenome;
    private int numeroRegistro;
    private List<Bilhete> bilhetes;

    public Cliente(String nome, String sobrenome, int numeroRegistro) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }
        if (sobrenome == null || sobrenome.isEmpty()) {
            throw new IllegalArgumentException("O sobrenome é obrigatório");
        }
        if (numeroRegistro <= 0) {
            throw new IllegalArgumentException("O número de registro deve ser positivo");
        }
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroRegistro = numeroRegistro;
        this.bilhetes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void addBilhete(Bilhete bilhete) {
        if (bilhete == null) {
            throw new IllegalArgumentException("O bilhete não pode ser nulo");
        }
        bilhetes.add(bilhete);
    }

    public double getTotal() {
        double total = 0;
        for (Bilhete bilhete : bilhetes) {
            total += bilhete.calcularPreco();
        }
        return total;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " (registro " + numeroRegistro + ")";
    }
}
