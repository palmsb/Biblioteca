import observer.ObservadorDeReserva;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String codigo;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String edicao;
    private int anoPublicacao;
    
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;
    private List<ObservadorDeReserva> observadores;

    public Livro(String codigo, String titulo, String editora, List<String> autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;

        this.exemplares = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.observadores = new ArrayList<>();

    }
    
     // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public List<Exemplar> getExemplares() { return exemplares; }
    public List<Reserva> getReservas() { return reservas; }

    // Adiciona um exemplar
    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }
    
    // Adiciona uma reserva e verifica se deve notificar
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        notificarSeNecessario();
    }

    // Adiciona um observador
    public void adicionarObservador(ObservadorDeReserva observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    // Notifica todos os observadores se houver mais de 2 reservas
    private void notificarSeNecessario() {
        if (reservas.size() > 2) {
            for (ObservadorDeReserva o : observadores) {
                o.notificarReservaExcedida();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Livro: %s (%s), %s, %s, %s, %d", titulo, codigo, editora, autores, edicao, anoPublicacao);
    }
}



