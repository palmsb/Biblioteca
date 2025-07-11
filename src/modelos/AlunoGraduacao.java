package modelos;

import estrategias.EmprestimoAlunoGraduacao;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.estrategia = new EmprestimoAlunoGraduacao();
    }

    @Override
    public String getTipo() {
        return "Aluno Graduação";
    }

    @Override
    public int getPrazoEmprestimoEmDias() {
        return 4;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 2;
    }
}