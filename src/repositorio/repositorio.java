package repositorio;

import modelos.*;
import java.util.*;

public class Repositorio {
    private static Repositorio instancia;

    private List<Usuario> usuarios;
    private List<Livro> livros;

    private Repositorio() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
        inicializarDadosDeTeste();
    }

    public static Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }

    public Usuario buscarUsuarioPorCodigo(String codigo) {
        for (Usuario u : usuarios) {
            if (u.getCodigo().equals(codigo)) {
                return u;
            }
        }
        return null;
    }

    public Livro buscarLivroPorCodigo(String codigo) {
        for (Livro l : livros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    private void inicializarDadosDeTeste() {
        // Usuários
        usuarios.add(new AlunoGraduacao("123", "João da Silva"));
        usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGraduacao("789", "Pedro Paulo"));
        usuarios.add(new Professor("100", "Carlos Lucena"));
    
        // Livros
        Livro l1 = new Livro("100", "Engenharia de Software", "Addison Wesley", List.of("Ian Sommerville"), "6ª", 2000);
        Livro l2 = new Livro("101", "UML - Guia do Usuário", "Campus", List.of("Grady Booch", "James Rumbaugh", "Ivar Jacobson"), "7ª", 2000);
        Livro l3 = new Livro("200", "Code Complete", "Microsoft Press", List.of("Steve McConnell"), "2ª", 2014);
        Livro l4 = new Livro("201", "Agile Software Development", "Prentice Hall", List.of("Robert Martin"), "1ª", 2002);
        Livro l5 = new Livro("300", "Refactoring", "Addison Wesley", List.of("Martin Fowler"), "1ª", 1999);
        Livro l6 = new Livro("301", "Software Metrics", "CRC Press", List.of("Norman Fenton", "James Bieman"), "3ª", 2014);
        Livro l7 = new Livro("400", "Design Patterns", "Addison Wesley", List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"), "1ª", 1994);
        Livro l8 = new Livro("401", "UML Distilled", "Addison Wesley", List.of("Martin Fowler"), "3ª", 2003);
    
        livros.addAll(List.of(l1, l2, l3, l4, l5, l6, l7, l8));
    
        // Exemplares (com referência ao livro)
        l1.adicionarExemplar(new Exemplar("01", l1));
        l1.adicionarExemplar(new Exemplar("02", l1));
        l2.adicionarExemplar(new Exemplar("03", l2));
        l3.adicionarExemplar(new Exemplar("04", l3));
        l4.adicionarExemplar(new Exemplar("05", l4));
        l5.adicionarExemplar(new Exemplar("06", l5));
        l5.adicionarExemplar(new Exemplar("07", l5));
        l7.adicionarExemplar(new Exemplar("08", l7));
        l7.adicionarExemplar(new Exemplar("09", l7));
    }
}
