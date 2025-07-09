package commands;

import modelos.*;
import observer.ObservadorDeReserva;
import repositorio.Repositorio;

public class ObservacaoCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: obs <codigoProfessor> <codigoLivro>");
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

        if (!(usuario instanceof ObservadorDeReserva)) {
            System.out.println("Apenas professores podem ser observadores de reserva.");
            return;
        }

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        livro.adicionarObservador((ObservadorDeReserva) usuario);
        System.out.println("Professor registrado como observador do livro com sucesso!");
    }
}
