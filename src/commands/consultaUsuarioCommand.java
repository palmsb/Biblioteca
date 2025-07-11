package commands;

import modelos.*;
import repositorio.Repositorio;

public class ConsultaUsuarioCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: usu <codigoUsuario>");
            return;
        }

        String codUsuario = args[0];
        Repositorio repo = Repositorio.getInstancia();
        Usuario usuario = repo.buscarUsuarioPorCodigo(codUsuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("=== Informações do Usuário ===");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Código: " + usuario.getCodigo());
        System.out.println("Tipo: " + usuario.getTipo());

        // empréstimos
        System.out.println("\n=== Empréstimos ===");
        if (usuario.getEmprestimos().isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
        } else {
            for (Emprestimo e : usuario.getEmprestimos()) {
                String tituloLivro = e.getExemplar().getLivro().getTitulo();
                String codigoExemplar = e.getExemplar().getCodigo();
                String status = e.estaEmAndamento()
                        ? "Em curso | Devolução prevista: " + e.getDataPrevistaDevolucao()
                        : "Finalizado em: " + e.getDataDevolucao();

                System.out.printf(" - Livro: %s | Exemplar: %s | Data do Empréstimo: %s | %s%n",
                        tituloLivro,
                        codigoExemplar,
                        e.getDataEmprestimo(),
                        status
                );
            }
        }

        // reservas
        System.out.println("\n=== Reservas ===");
        if (usuario.getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
        } else {
            for (Reserva r : usuario.getReservas()) {
                Livro livro = r.getLivro();
                String titulo = (livro != null) ? livro.getTitulo() : "Livro desconhecido";
                System.out.printf(" - Livro: %s | Data da Reserva: %s%n", titulo, r.getDataReserva());
            }
        }
    }
}
