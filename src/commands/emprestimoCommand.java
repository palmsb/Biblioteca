package commands;

import modelos.*;
import repositorio.Repositorio;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: emp <codigoUsuario> <codigoLivro>");
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

        // Verifica se o usuário já tem um exemplar desse livro emprestado
        for (Emprestimo e : usuario.getEmprestimos()) {
            if (e.estaEmAndamento() && e.getExemplar() != null && livro.getExemplares().contains(e.getExemplar())) {
                System.out.println("Não foi possível realizar o empréstimo, pois o usuário já tem um exemplar deste mesmo livro em empréstimo no momento.");
                return;
            }
        }

        // Verifica se há exemplar disponível
        Exemplar exemplarDisponivel = livro.getExemplares().stream()
                .filter(Exemplar::isDisponivel)
                .findFirst()
                .orElse(null);

        if (exemplarDisponivel == null) {
            System.out.println("Não há exemplares disponíveis para empréstimo.");
            return;
        }

        // Verifica se a estratégia permite o empréstimo
        if (!usuario.getEstrategia().podeEmprestar(usuario, livro)) {
            System.out.println("Empréstimo não permitido pelas regras do sistema.");
            return;
        }

        // Remove reserva do usuário, se existir
        List<Reserva> reservas = livro.getReservas();
        reservas.removeIf(r -> r.getUsuario().equals(usuario));

        // Cria o empréstimo
        Emprestimo emprestimo = new Emprestimo(usuario, exemplarDisponivel, LocalDate.now());
        System.out.println("Empréstimo realizado com sucesso!");
    }
}
