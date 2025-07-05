package modelos;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private LocalDate dataReserva;

    public Reserva(Usuario usuario, LocalDate dataReserva) {
        this.usuario = usuario;
        this.dataReserva = dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    @Override
    public String toString() {
        return String.format("Reserva de %s em %s", usuario.getNome(), dataReserva);
    }
}
