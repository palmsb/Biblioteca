package estrategias;

import modelos.usuario;
import modelos.livro;

public interface EstrategiaEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
} 