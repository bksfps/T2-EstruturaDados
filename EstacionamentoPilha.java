import java.time.Duration;
import java.time.LocalDateTime;

public class EstacionamentoPilha {
    private Pilha<Carro> pilha;
    private int capacidadeMaxima;

    public EstacionamentoPilha(int capacidadeMaxima) {
        this.pilha = new Pilha<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public boolean entradaCarro(Carro carro) {
        if (pilha.tamanho() < capacidadeMaxima) {
            pilha.push(carro);
            return true;
        } else {
            return false;
        }
    }

    public void saidaCarro(String placa) {
        Pilha<Carro> pilhaAux = new Pilha<>();
        Carro carro = null;
        int manobras = 0;

        while (!pilha.estaVazia()) {
            Carro topo = pilha.pop();
            manobras++;
            if (topo.getPlaca().equals(placa)) {
                carro = topo;
                break;
            } else {
                pilhaAux.push(topo);
            }
        }

        while (!pilhaAux.estaVazia()) {
            pilha.push(pilhaAux.pop());
        }

        if (carro != null) {
            carro.setHorarioSaida(LocalDateTime.now());
            Duration duracao = Duration.between(carro.getHorarioEntrada(), carro.getHorarioSaida());
            System.out.println("Carro removido: " + carro);
            System.out.println("Tempo de permanencia: " + duracao.toMinutes() + " minutos");
            System.out.println("Numero de manobras: " + manobras);
        } else {
            System.out.println("Carro com placa " + placa + " nao encontrado.");
        }
    }

    public void consultaCarro(String placa) {
        Pilha<Carro> pilhaAux = new Pilha<>();
        Carro carro = null;
        int posicao = 0;

        while (!pilha.estaVazia()) {
            Carro topo = pilha.pop();
            pilhaAux.push(topo);
            posicao++;
            if (topo.getPlaca().equals(placa)) {
                carro = topo;
                break;
            }
        }

        while (!pilhaAux.estaVazia()) {
            pilha.push(pilhaAux.pop());
        }

        if (carro != null) {
            System.out.println("Carro encontrado: " + carro);
            System.out.println("Posicao na pilha: " + posicao);
        } else {
            System.out.println("Carro com placa " + placa + " nao encontrado.");
        }
    }

    public void estadoAtual() {
        System.out.println(pilha);
    }
}
