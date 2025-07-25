package modelos;

import estrategias.EmprestimoProfessor;
import observer.ObservadorDeReserva;

public class Professor extends Usuario implements ObservadorDeReserva {

    private int totalNotificacoes = 0;

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        this.estrategia = new EmprestimoProfessor();
    }

    @Override
    public String getTipo() {
        return "Professor";
    }

    @Override
    public int getPrazoEmprestimoEmDias() {
        return 8;
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE; 
    }

    @Override
    public void notificarReservaExcedida() {
        totalNotificacoes++;
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }
}

//o