public class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String codigo, String nome) {
        this.estrategia = new EmprestimoAlunoGraduacao();
    }

    @Override
    public String getTipo() {
        return "Aluno Graduação";
    }
}