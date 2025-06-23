public class Professor extends Usuario implements ObservadorDeReserva {
    private int totalNotificacoes = 0;

    @Override
    public void notificarReservaExcedida() {
        totalNotificacoes++;
    }

    public int getTotalNotificacoes() {
        return totalNotificacoes;
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}