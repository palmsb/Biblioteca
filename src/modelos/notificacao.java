package modelos;

import java.time.LocalDate;

public class Notificacao {
    private Professor observador;
    private Livro livro;
    private LocalDate data;

    public Notificacao(Professor observador, Livro livro, LocalDate data) {
        this.observador = observador;
        this.livro = livro;
        this.data = data;
    }

    public Professor getObservador() {
        return observador;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("Notificação para %s sobre o livro \"%s\" em %s",
                observador.getNome(), livro.getTitulo(), data);
    }
}
