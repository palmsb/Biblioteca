package commands;

import modelos.*;
import repositorio.Repositorio;

public class ConsultaLivroCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: liv <codigoLivro>");
            return;
        }

        String codLivro = args[0];
        Repositorio repo = Repositorio.getInstancia();
        Livro livro = repo.buscarLivroPorCodigo(codLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        // dados básicos do livro
        System.out.println("=== Dados do Livro ===");
        System.out.println("Título: " + livro.getTitulo());
        System.out.println("Código: " + livro.getCodigo());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Autores: " + String.join(", ", livro.getAutores()));
        System.out.println("Edição: " + livro.getEdicao());
        System.out.println("Ano: " + livro.getAnoPublicacao());

        // lista de reservas
        System.out.println("\n=== Reservas ===");
        if (livro.getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva.");
        } else {
            int pos = 1;
            for (Reserva r : livro.getReservas()) {
                System.out.printf("%d. %s (%s)\n", pos++, r.getUsuario().getNome(), r.getUsuario().getCodigo());
            }
        }

        // lista de exemplares
        System.out.println("\n=== Exemplares ===");
        for (Exemplar ex : livro.getExemplares()) {
            String status = ex.isEmprestado() ? "Emprestado" : "Disponível";
            Emprestimo emprestimoAtual = null;

            for (Emprestimo e : livro.getHistoricoEmprestimos()) {
                if (e.getExemplar().equals(ex) && e.estaEmAndamento()) {
                    emprestimoAtual = e;
                    break;
                }
            }

            System.out.printf("Exemplar %s - %s", ex.getCodigo(), status);

            if (emprestimoAtual != null) {
                System.out.printf(" | Usuário: %s (%s)", 
                    emprestimoAtual.getUsuario().getNome(), 
                    emprestimoAtual.getUsuario().getCodigo());
                System.out.printf(" | Data de Empréstimo: %s", emprestimoAtual.getDataEmprestimo());
                System.out.printf(" | Data de Devolução Prevista: %s", emprestimoAtual.getDataPrevistaDevolucao());
            }

            System.out.println();
        }
    }
}
