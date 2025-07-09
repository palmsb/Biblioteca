package commands;

import modelos.*;
import repositorio.Repositorio;

public class ConsultaNotificacoesCommand implements Comando {

    @Override
    public void executar(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: ntf <codigoProfessor>");
            return;
        }

        String codUsuario = args[0];
        Repositorio repo = Repositorio.getInstancia();
        Usuario usuario = repo.buscarUsuarioPorCodigo(codUsuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (!(usuario instanceof Professor)) {
            System.out.println("Este usuário não é um professor.");
            return;
        }

        Professor professor = (Professor) usuario;
        System.out.printf("🔔 O professor %s recebeu %d notificações.%n",
                professor.getNome(), professor.getTotalNotificacoes());
    }
}
