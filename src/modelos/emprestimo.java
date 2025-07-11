package modelos;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private boolean finalizado;

    public Emprestimo(Usuario usuario, Exemplar exemplar, LocalDate dataEmprestimo) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataEmprestimo.plusDays(usuario.getPrazoEmprestimoEmDias());
        this.finalizado = false;
        this.dataDevolucao = null;

        exemplar.emprestar(); // marca exemplar como emprestado
        usuario.getEmprestimos().add(this); // adiciona ao histórico do usuário
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean estaEmAndamento() {
        return !finalizado;
    }

    public boolean estaAtrasado(LocalDate hoje) {
        return estaEmAndamento() && hoje.isAfter(dataPrevistaDevolucao);
    }

    public void registrarDevolucao(LocalDate data) {
        this.dataDevolucao = data;
        this.finalizado = true;
        exemplar.devolver();
    }

    @Override
    public String toString() {
        return String.format("Empréstimo de %s (%s) - Exemplar %s\nData: %s | Devolução Prevista: %s | %s",
                exemplar.getCodigo(), usuario.getNome(), exemplar.getCodigo(),
                dataEmprestimo, dataPrevistaDevolucao,
                finalizado ? "Finalizado em " + dataDevolucao : "Em curso");
    }
}


