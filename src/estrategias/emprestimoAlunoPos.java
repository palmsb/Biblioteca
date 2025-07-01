package modelos;

import estrategias.emprestimoAlunoPos;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.estrategia = new EmprestimoAlunoPos();
    }

    @Override
    public String getTipo() {
        return "Aluno Pós-Graduação";
    }

    @Override
    public int getPrazoEmprestimoEmDias() {
        return 5;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}