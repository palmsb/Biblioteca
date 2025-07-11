package modelos;

import estrategias.EstrategiaEmprestimo;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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

    public boolean temEmprestimosAtrasados() {
        LocalDate hoje = LocalDate.now();
        for (Emprestimo e : emprestimos) {
            if (e.estaAtrasado(hoje)) {
                return true;
            }
        }
        return false;
    }

    
    public List<Emprestimo> getEmprestimosEmAberto() {
        List<Emprestimo> emAberto = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (e.estaEmAndamento()) {
                emAberto.add(e);
            }
        }
        return emAberto;
    }

    
    public boolean temExemplarDoLivro(Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.estaEmAndamento() &&
                e.getExemplar() != null &&
                e.getExemplar().getLivro().equals(livro)) {
                return true;
            }
        }
        return false;
    }

    
    public void registrarEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    
    public void registrarReserva(Reserva r) {
        reservas.add(r);
    }

    public abstract String getTipo();
    public abstract int getPrazoEmprestimoEmDias();
    public abstract int getLimiteEmprestimos();
}

