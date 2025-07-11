package modelos;

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
    private List<Emprestimo> historicoEmprestimos = new ArrayList<>();
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
        this.historicoEmprestimos = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public List<String> getAutores() {
        return autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    // retorna o primeiro exemplar disponível
    public Exemplar getExemplarDisponivel() {
        for (Exemplar ex : exemplares) {
            if (!ex.isEmprestado()) {
                return ex;
            }
        }
        return null;
    }

    
    public int getQuantidadeExemplaresDisponiveis() {
        int count = 0;
        for (Exemplar ex : exemplares) {
            if (!ex.isEmprestado()) {
                count++;
            }
        }
        return count;
    }

    
    public boolean usuarioTemReserva(Usuario usuario) {
        for (Reserva r : reservas) {
            if (r.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    
    public void cancelarReservaDoUsuario(Usuario usuario) {
        reservas.removeIf(r -> r.getUsuario().equals(usuario));
    }

    
    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    // registra novo empréstimo no histórico
    public void registrarEmprestimo(Emprestimo e) {
        historicoEmprestimos.add(e);
    }

    // adiciona uma nova reserva e notifica se necessário
    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        notificarSeNecessario();
    }

    //  adiciona um professor observador ----> Observer
    public void adicionarObservador(ObservadorDeReserva observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    // notificar professores se houver mais de 2 reservas
    private void notificarSeNecessario() {
        if (reservas.size() > 2) {
            for (ObservadorDeReserva o : observadores) {
                o.notificarReservaExcedida();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Livro: %s (%s), %s, %s, %s, %d",
                titulo, codigo, editora, autores, edicao, anoPublicacao);
    }
}
