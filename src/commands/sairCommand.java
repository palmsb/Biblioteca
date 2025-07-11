package commands;

public class SairCommand implements Comando {

    @Override
    public void executar(String[] args) {
        System.out.println("Sistema encerrado! Volte Sempre!");
        System.exit(0);
    }
}


