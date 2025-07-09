package commands;

import modelos.*;
import repositorio.Repositorio;

import java.time.LocalDate;

public class ReservaCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: res <codigoUsuario> <codigoLivro>");
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

        // Verifica se o usuário já tem uma reserva para esse livro
        for (Reserva r : livro.getReservas()) {
            if (r.getUsuario().equals(usuario)) {
                System.out.println("O usuário já possui uma reserva para este livro.");
                return;
            }
        }

        // Cria e registra a reserva
        Reserva reserva = new Reserva(usuario, LocalDate.now());
        livro.adicionarReserva(reserva);
        usuario.getReservas().add(reserva);

        System.out.println("Reserva registrada com sucesso!");
    }
}
