package commands;

import modelos.*;
import repositorio.Repositorio;

import java.time.LocalDate;

public class DevolucaoCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: dev <codigoUsuario> <codigoLivro>");
            return;
        }

        String codUsuario = args[0];
        String codLivro = args[1];

        Repositorio repo = Repositorio.getInstancia();
        Usuario usuario = repo.buscarUsuarioPorCodigo(codUsuario);
        Livro livro = repo.buscarLivroPorCodigo(codLivro);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        // procura se tem um empréstimo em andamento do usuário para um exemplar desse livro
        Emprestimo emprestimoParaDevolver = null;
        for (Emprestimo e : usuario.getEmprestimos()) {
            if (e.estaEmAndamento() && livro.getExemplares().contains(e.getExemplar())) {
                emprestimoParaDevolver = e;
                break;
            }
        }

        if (emprestimoParaDevolver == null) {
            System.out.println("Nenhum empréstimo em andamento encontrado para este livro.");
            return;
        }

        emprestimoParaDevolver.registrarDevolucao(LocalDate.now());
        System.out.println("Devolução registrada com sucesso!");
    }
}
