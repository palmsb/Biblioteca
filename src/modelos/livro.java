public class Livro {
    private String codigo;
    private String titulo;
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;
    private List<ObservadorDeReserva> observadores;
}

//criar a função para notificar