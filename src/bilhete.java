
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
        }
        return true;
    }
    public double calcularPreco(){
        
    }


     }
