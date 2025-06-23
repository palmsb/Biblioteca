public abstract class Usuario {
    protected String codigo;
    protected String nome;
    protected EstrategiaEmprestimo estrategia;

    public abstract String getTipo();
}

