package modelos;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private LocalDate dataReserva;
    private Livro livro;

    public Reserva(Usuario usuario, Livro livro, LocalDate dataReserva) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public Livro getLivro() {
        return livro;
    }

    @Override
    public String toString() {
        return String.format("Reserva de %s em %s", usuario.getNome(), dataReserva);
    }
}
