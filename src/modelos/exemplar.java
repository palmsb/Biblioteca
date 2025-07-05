package modelos;

public class Exemplar {
    private String codigo;
    private boolean emprestado;

    public Exemplar(String codigo) {
        this.codigo = codigo;
        this.emprestado = false; // por padrão, está disponível
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public boolean isDisponivel() {
        return !emprestado;
    }

    public void emprestar() {
        this.emprestado = true;
    }

    public void devolver() {
        this.emprestado = false;
    }

    @Override
    public String toString() {
        return String.format("Exemplar %s - %s", codigo, emprestado ? "Emprestado" : "Disponível");
    }
}
