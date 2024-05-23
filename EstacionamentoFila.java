import java.time.Duration;
import java.time.LocalDateTime;

public class EstacionamentoFila {
    private Fila<Carro> fila;
    private int capacidadeMaxima;

    public EstacionamentoFila(int capacidadeMaxima) {
        this.fila = new Fila<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean entradaCarro(Carro carro) {
        if (fila.tamanho() < capacidadeMaxima) {
            fila.enfileira(carro);
            return true;
        } else {
            return false;
        }
    }

    public void saidaCarro() {
        if (fila.estaVazia()) {
            System.out.println("O estacionamento esta vazio.");
            return;
        }
        Carro carro = fila.desenfileira();
        carro.setHorarioSaida(LocalDateTime.now());
        Duration duracao = Duration.between(carro.getHorarioEntrada(), carro.getHorarioSaida());
        System.out.println("Carro removido: " + carro);
        System.out.println("Tempo de permanencia: " + duracao.toMinutes() + " minutos");
        System.out.println("Numero de manobras: 1");
    }

    public void consultaCarro(String placa) {
        Fila<Carro> filaAux = new Fila<>();
        Carro carro = null;
        int posicao = 0;

        while (!fila.estaVazia()) {
            Carro frente = fila.desenfileira();
            filaAux.enfileira(frente);
            posicao++;
            if (frente.getPlaca().equals(placa)) {
                carro = frente;
                break;
            }
        }

        while (!filaAux.estaVazia()) {
            fila.enfileira(filaAux.desenfileira());
        }

        if (carro != null) {
            System.out.println("Carro encontrado: " + carro);
            System.out.println("Posicao na fila: " + posicao);
        } else {
            System.out.println("Carro com placa " + placa + " nao encontrado.");
        }
    }

    public void estadoAtual() {
        System.out.println(fila);
    }
}
