public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(String codigo, String nome) {
        this.estrategia = new EmprestimoAlunoPos();
    }

    @Override
    public String getTipo() {
        return "Aluno Pós-Graduação";
    }
}