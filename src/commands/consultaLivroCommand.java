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

       
