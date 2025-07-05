package modelos;

import estrategias.EstrategiaEmprestimo;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String codigo;
    protected String nome;
    protected EstrategiaEmprestimo estrategia;

    protected List<Emprestimo> emprestimos;
    protected List<Reserva> reservas;

    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public EstrategiaEmprestimo getEstrategia() {
        return estrategia;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public abstract String getTipo();
    public abstract int getPrazoEmprestimoEmDias();
    public abstract int getLimiteEmprestimos();
}
