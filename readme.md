## Raciocinio

1. Análise do Escopo e Requisitos
O sistema é uma simulação de biblioteca acadêmica, com empréstimos, devoluções, reservas, observações e consultas.

Deve rodar via linha de comando e não usa banco de dados.

Deve aplicar os padrões:

Singleton (para o Repositorio)

Command (para comandos de texto)

Strategy (para regras de empréstimo, sem if/switch)

2.  Modelagem Inicial – Classes
Seguir o modelo conceitual do PDF.

Usuario (abstract)

Subclasses: AlunoGraduacao, AlunoPosGraduacao, Professor

Livro

Exemplar

Emprestimo

Reserva

Notificacao

Repositorio (Singleton: armazena livros, usuários, reservas, etc.)



3. Criação de Estratégias (Padrão Strategy)
Cada tipo de usuário tem uma regra de empréstimo:

Criar interface EstrategiaEmprestimo

Criar implementações separadas:

EmprestimoAlunoGraduacao

EmprestimoAlunoPos

EmprestimoProfessor

Cada Usuario terá uma instância de sua estratégia.

4. Implementação de Comandos (Padrão Command)
Com base na entrada do usuário:

Interface Comando com método executar(String[] parametros)

Um comando por funcionalidade:

emp → EmprestimoCommand

dev → DevolucaoCommand

res → ReservaCommand

obs → ObservacaoCommand

liv → ConsultaLivroCommand

usu → ConsultaUsuarioCommand

ntf → ConsultaNotificacoesCommand

sai → SairCommand

O SistemaConsole será responsável por interpretar comandos e delegar execução.

5. Leitura de Comandos
Na classe SistemaConsole:

Use Scanner para capturar entrada do usuário

Faça parsing do texto e escolha o comando correspondente por um mapa de strings para comandos, evitando if/switch.

Exemplo:
Map<String, Comando> comandos = new HashMap<>();
comandos.put("emp", new EmprestimoCommand());
comandos.put("dev", new DevolucaoCommand());

6. ConsultaLivroCommand mostra status dos exemplares, reservas e empréstimos.

ConsultaUsuarioCommand lista empréstimos (em andamento e finalizados) e reservas.

ConsultaNotificacoesCommand mostra total de notificações recebidas por um professor.



7. Populando o Sistema (Dados de Teste)
No Main.java, instanciar os usuários, livros, exemplares e adicionar no Repositorio.

Isso substitui a necessidade de banco de dados.

8. Observação e Notificação (Padrão Observer)

Professores podem ser observadores de livros.

Quando reservas > 2:

Notifica observadores

Incrementa contador no professor

Isso pode ser feito com:

Livro mantendo uma lista de ObservadorReserva

Professor implementando a interface ObservadorReserva


## Padrões Utilizados

1. Singleton ->  Repositorio

Por quê? Garante que haja apenas uma instância responsável por armazenar os dados (usuários, livros, etc.).

Benefício: Centraliza o acesso aos dados e facilita o controle.

2. Command -> Em cada comando digitado pelo usuário (emp, dev, res, etc.)

Por quê? Encapsula uma solicitação como um objeto, desacoplando o emissor do comando (SistemaConsole) do executor.

Benefício: Facilita a adição de novos comandos sem modificar o código existente (aberto para extensão, fechado para modificação).

3. Strategy -> Nas regras de empréstimo específicas de cada tipo de usuário

Por quê? Permite definir diferentes comportamentos de empréstimo (Aluno Graduação, Pós, Professor) e mudar a lógica em tempo de execução.

Benefício: Evita o uso de if-else ou switch, e facilita incluir novos tipos de usuários no futuro.


## Próximos passos:

[x] Criar a estrutura de pacotes e arquivos

[] Implementar o Singleton -> Repositorio

[] Criar os métodos buscarUsuarioPorCodigo(), buscarLivroPorCodigo(),adicionarUsuario(), adicionarLivro(), etc.

[] Criar classes bases do modelo: Usuario (classe abstrata): AlunoGraduacao, AlunoPosGraduacao, Professor
Livro, Exemplar
Reserva, Emprestimo

[] Criar a interface EstrategiaEmprestimo

Implemente:
EmprestimoAlunoGraduacao
EmprestimoAlunoPos
EmprestimoProfessor

Associe cada estratégia a seu respectivo Usuario.

[] Implementar o sistema de comandos (Command):
Crie a interface Comando { void executar(String[] args); }

Para cada comando (emp, dev, res, obs, liv, usu, ntf, sai), crie uma classe específica que implemente Comando.

[]Criar o SistemaConsole
Usar um Scanner para ler linha a linha do console

Mapear cada prefixo de comando para a classe correspondente (ex: Map<String, Comando>)

Chamar o método executar() com os argumentos

[] Popule os dados de teste em Main.java
Instancie os usuários, livros, exemplares conforme a seção 7 do PDF
Adicione todos ao Repositorio.getInstancia()

[] Implementar funcionalidades adicionais
Lógica de reservas, devoluções, e observações de livros.
Atualize os comandos correspondentes.

[] Testar todos os comandos

[] Criar o Diagrama de Classes para Apresentação


