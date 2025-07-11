package estrategias;

import modelos.Usuario;
import modelos.Livro;

public interface EstrategiaEmprestimo {
    boolean podeEmprestar(Usuario usuario, Livro livro);
} 

