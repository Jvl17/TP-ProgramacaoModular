// Agente utilizado: Claude Opus 5.5 (usado para criar o esqueleto do App.java)

import java.util.ArrayList;
import java.util.List;

public class App {

    static List<Cliente> clientes = new ArrayList<>();
    static List<Rota> rotas = new ArrayList<>();
    static List<Voo> voos = new ArrayList<>();
    static List<Bilhete> bilhetes = new ArrayList<>();

    // Solicita um número enquanto um valor válido não for digitado
    static int lerNumero(String mensagem) {
        while (true) {
            try {
                return Integer.parseInt(IO.readln(mensagem));
            } catch (NumberFormatException e) {
                IO.println("Valor inválido. Digite apenas números.");
            }
        }
    }

    // Aluno 2 (João Vitor): loop principal, repete o menu até o usuário escolher sair
    public static void main(String[] args) {
        // TODO
    }

    // Aluno 1 (Matheus Perona): mostra as opções do menu
    static void mostrarMenu() {
        // TODO
    }

    // Aluno 1 (Matheus Perona): gera todas as rotas entre as cidades do enum Cidade
    static void gerarRotas() {
        // TODO
    }

    // Aluno 2 (João Vitor): pede origem, destino e data e lista os voos disponíveis
    static void procurarVoos() {
        // TODO
    }

    // Aluno 3 (Rafael Santos): pede nome, sobrenome e número de registro e cadastra o cliente
    static void cadastrarCliente() {
        IO.println("\n--- Cadastrar cliente ---");
        String nome = IO.readln("Nome: ");
        String sobrenome = IO.readln("Sobrenome: ");
        int numeroRegistro = lerNumero("Número de registro: ");

        try {
            Cliente cliente = new Cliente(nome, sobrenome, numeroRegistro);
            clientes.add(cliente);
            IO.println("Cliente cadastrado: " + cliente);
        } catch (IllegalArgumentException e) {
            IO.println("Erro: " + e.getMessage());
        }
    }

    // Aluno 3 (Rafael Santos): cria um bilhete para um cliente e adiciona voos respeitando a regra de conexão
    static void criarBilhete() {
        IO.println("\n--- Criar bilhete ---");

        if (clientes.isEmpty()) {
            IO.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
            return;
        }
        if (voos.isEmpty()) {
            IO.println("Nenhum voo cadastrado. Cadastre um voo primeiro.");
            return;
        }

        IO.println("Clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            IO.println((i + 1) + " - " + clientes.get(i));
        }

        int escolhaCliente = lerNumero("Escolha o cliente: ");
        if (escolhaCliente < 1 || escolhaCliente > clientes.size()) {
            IO.println("Cliente inválido.");
            return;
        }

        Cliente cliente = clientes.get(escolhaCliente - 1);
        Bilhete bilhete = new Bilhete(cliente);
        int escolhaVoo;

        do {
            IO.println("\nVoos disponíveis:");
            for (int i = 0; i < voos.size(); i++) {
                Voo voo = voos.get(i);
                IO.println(String.format("%d - %s | %s | R$ %.2f", i + 1, voo.getRota(), voo.getData(), voo.getPrecoBase()));
            }

            escolhaVoo = lerNumero("Escolha o voo (0 para finalizar): ");

            if (escolhaVoo >= 1 && escolhaVoo <= voos.size()) {
                if (bilhete.adicionarVoo(voos.get(escolhaVoo - 1))) {
                    IO.println("Voo adicionado ao bilhete.");
                } else {
                    IO.println("Esse voo não conecta com o anterior (origem diferente do último destino ou data fora do prazo).");
                }
            } else if (escolhaVoo != 0) {
                IO.println("Voo inválido.");
            }
        } while (escolhaVoo != 0);

        if (bilhete.getVoos().isEmpty()) {
            IO.println("Bilhete cancelado: nenhum voo foi adicionado.");
            return;
        }

        bilhetes.add(bilhete);
        IO.println("Bilhete criado para " + cliente + ": " + bilhete.getOrigem() + " -> " + bilhete.getDestino());
        IO.println(String.format("Preço total: R$ %.2f", bilhete.calcularPreco()));
    }

    // Aluno 4 (Caio Mayllart): cadastra um voo com rota, data e preço base
    static void cadastrarVoo() {
        // TODO
    }

    // Aluno 4 (Caio Mayllart): associa um bilhete criado ao cliente
    static void comprarBilhete() {
        // TODO
    }
}
