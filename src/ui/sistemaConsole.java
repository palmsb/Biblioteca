package ui;

import commands.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe responsável pela interação com o usuário via linha de comando.
 * Utiliza o padrão Comando para executar as ações.
 */
public class SistemaConsole {

    private final Map<String, Comando> comandos = new HashMap<>();

    public SistemaConsole() {
        // Mapeia os comandos do sistema
        comandos.put("emp", new EmprestimoCommand());
        comandos.put("dev", new DevolucaoCommand());
        comandos.put("res", new ReservaCommand());
        comandos.put("obs", new ObservacaoCommand());
        comandos.put("liv", new ConsultaLivroCommand());
        comandos.put("usu", new ConsultaUsuarioCommand());
        comandos.put("ntf", new ConsultaNotificacoesCommand());
        comandos.put("sai", new SairCommand());
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à Biblioteca ENGSOFT!");
        System.out.println("Comandos disponíveis: emp, dev, res, obs, liv, usu, ntf, sai");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) continue;

            String[] partes = entrada.split("\\s+");
            String nomeComando = partes[0];
            String[] args = Arrays.copyOfRange(partes, 1, partes.length);

            Comando comando = comandos.get(nomeComando);
            if (comando != null) {
                try {
                    comando.executar(args);
                } catch (Exception e) {
                    System.out.println("Erro ao executar o comando: " + e.getMessage());
                }
            } else {
                System.out.println("Comando não reconhecido: " + nomeComando);
            }
        }
    }
}
