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

        System.out.println("👤 Usuário: " + usuario.getNome());
        System.out.println("Código: " + usuario.getCodigo());
        System.out.println("Tipo: " + usuario.getTipo());

        System.out.println("\n📚 Empréstimos em andamento:");
        boolean temEmprestimos = false;
        for (Emprestimo e : usuario.getEmprestimos()) {
            if (e.estaEmAndamento()) {
                System.out.println(" - " + e);
                temEmprestimos = true;
            }
        }
        if (!temEmprestimos) {
            System.out.println("Nenhum empréstimo em andamento.");
        }

        System.out.println("\n📑 Reservas:");
        if (usuario.getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
        } else {
            for (Reserva r : usuario.getReservas()) {
                System.out.printf(" - Livro: %s | Data: %s%n", r.getLivro().getTitulo(), r.getDataReserva());
            }
        }
    }
}
