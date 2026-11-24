public class Bilhete {
    private Cliente cliente;
    private List<Voo> voos = new ArrayList<>();

    public Bilhete(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean adicionarVoo(Voo v) {
        if (v == null) return false;
        if (voos.isEmpty()) {
            Voo ultimo = voos.get(voos.size() - 1);          
            if (ultimo.getDestino() != v.getOrigem()) return false;
            long dias = ChronoUnit.DAYS.between(ultimo.getData(), v.getData());
            if (dias < 0 || dias > 1) return false;
        }
        voos.add(v);
        return true;
    }

    public double calcularPreco() {
        List<Double> precos = new ArrayList<>();
        for (Voo v : voos) precos.add(v.getPrecoBase());
        precos.sort(Comparator.reverseOrder());

        double total = 0;
        for (int i = 0; i < precos.size(); i++) {
            if (i == 0) total += precos.get(i) * 0.60;
            else if (i == 1) total += precos.get(i) * 0.40;
            else total += precos.get(i) * 0.10;
        }
        return total;
    }

    public Cliente getCliente() { return cliente; }
    public List<Voo> getVoos() { return voos; }
    public Cidade getOrigem() { return voos.get(0).getOrigem(); }
    public Cidade getDestino() { return voos.get(voos.size() - 1).getDestino(); }
}

// Tentei de verdade mas tive auxilio da IA Claude modelo Sonnet 5.5