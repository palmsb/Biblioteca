package estrategias;

import modelos.*;

public class EmprestimoProfessor implements EstrategiaEmprestimo {

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (livro.getExemplarDisponivel() == null) return false;

        if (usuario.temEmprestimosAtrasados()) return false;

        return true;
    }
}
