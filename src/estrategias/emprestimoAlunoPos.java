package estrategias;

import modelos.*;

public class EmprestimoAlunoPos implements EstrategiaEmprestimo {

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (livro.getExemplarDisponivel() == null) return false;

        if (usuario.temEmprestimosAtrasados()) return false;

        if (usuario.getEmprestimosEmAberto().size() >= usuario.getLimiteEmprestimos()) return false;

        if (livro.getReservas().size() >= livro.getQuantidadeExemplaresDisponiveis()
            && !livro.usuarioTemReserva(usuario)) return false;

        return true;
    }
}

