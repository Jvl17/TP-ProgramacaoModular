# TP — XAVi · Última parte

**Programação Modular · 2026/2**

Esta é a **última parte** do trabalho prático.

Em aula, cada grupo deve começar a classe `App.java` com as assinaturas dos métodos que fazem o sistema rodar. A tarefa de casa é **implementar esses métodos**: **dois métodos por aluno**. O `App` do grupo precisa ter, no mínimo, os oito abaixo.

## Métodos

1. **Mostrar o menu** do usuário.
2. **Loop principal** no `main`, que repete o menu até a saída.
3. **Cadastrar cliente** (nome, sobrenome e número de registro).
4. **Gerar automaticamente as rotas** entre as cidades atendidas (Belo Horizonte, Fortaleza, Recife, João Pessoa, São Luís e Natal), usando o enum `Cidade` e a classe `Rota`. O usuário não cadastra rota por rota.
5. **Cadastrar voos**: uma rota, uma data e o preço base.
6. **Procurar voos**: origem, destino e data, e a lista do que estiver disponível.
7. **Criar bilhete**, com a regra de conexão já definida na classe `Bilhete` (origem do voo seguinte igual ao destino do anterior; mesmo dia ou dia seguinte) e o preço de venda dessa classe.
8. **Comprar um bilhete**, associando o bilhete ao cliente.

## Quem faz o quê

Cada aluno implementa **dois** métodos. Divisão alinhada às classes da Tarefa 3:

| Aluno | Métodos |
|---|---|
| 1 | Gerar as rotas; mostrar o menu |
| 2 | loop principal; procurar voos |
| 3 | Cadastrar cliente; Criar bilhete |
| 4 | Cadastrar voos; comprar um bilhete |


## O que precisa estar pronto

Na **próxima semana** o grupo apresenta o sistema **funcionando**: o programa abre, o menu aparece e dá para cumprir o fluxo — cadastrar cliente, ter as rotas geradas, cadastrar e procurar voos, criar um bilhete e comprar.

Não é uma apresentação de assinatura vazia. O código da `main` tem que rodar esse fluxo com as classes do grupo.

## Entrega

Entrega no **Canvas até domingo, 29/11**.

No Canvas: link do repositório do grupo, com o `App.java` e o restante do código na versão que será apresentada.

## Uso de IA / agentes

Vale a mesma regra da Tarefa 3. O recomendado é não usar agente de código nesta parte. Se usar:

1. Declarar o agente e a versão no cabeçalho da classe.
2. Primeiro commit com o código gerado.
3. Segundo commit, seu, com o que você revisou e alterou.
4. Você pode ser entrevistado sobre o código. Ele pode ter sido gerado por um agente, mas tem que ser compreendido por você.
5. Descumprir qualquer passo, ou não conseguir explicar o código na entrevista, conta como atividade não realizada.
