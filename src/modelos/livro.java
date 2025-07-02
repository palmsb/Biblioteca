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

    public Livro(int codigo, String titulo, String editora, List<String> autores, String edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

}

//criar a função para notificar
