package commands;

/**
 * Interface base para todos os comandos do sistema de biblioteca.
 * Cada comando que vai do console (emp, dev, res, obs, etc) é para implementar essa interface
 */
public interface Comando {
    void executar(String[] args);
}


