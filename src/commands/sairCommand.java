package commands;

public class SairCommand implements Comando {

    @Override
    public void executar(String[] args) {
        System.out.println("Encerrando o sistema. Até logo! 👋");
        System.exit(0);
    }
}
