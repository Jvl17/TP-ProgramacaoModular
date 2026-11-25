import java.time.LocalDate;

public class Voo {
    public static final int CAPACIDADE_MAXIMA = 150;

    private Rota rota;
    private LocalDate data;
    private double precoBase;

    public Voo(Rota rota, LocalDate data, double precosBase) {
        if (rota == null)
            throw new IllegalArgumentException("A rota é obrigatória");
        if (data == null)
            throw new IllegalArgumentException("A data é obrigatória");
        this.rota = rota;
        this.data = data;
        setPrecoBase(precosBase);
    }

    public Rota getRota() {
        return rota;
    }

    public LocalDate getData() {
        return data;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precosBase) {
        if (precosBase <= 0) 
            throw new IllegalArgumentException("O preço base deve ser positivo");
        
        this.precoBase = precosBase;
    }
}