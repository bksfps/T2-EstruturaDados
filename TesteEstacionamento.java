import java.time.LocalDateTime;

public class TesteEstacionamento {
    public static void main(String[] args) {
        EstacionamentoPilha estacionamentoPilha = new EstacionamentoPilha(5);
        EstacionamentoFila estacionamentoFila = new EstacionamentoFila(5);

        Carro carro1 = new Carro("AAA-1111", LocalDateTime.now());
        Carro carro2 = new Carro("BBB-2222", LocalDateTime.now().plusMinutes(5));
        Carro carro3 = new Carro("CCC-3333", LocalDateTime.now().plusMinutes(10));
        Carro carro4 = new Carro("DDD-4444", LocalDateTime.now().plusMinutes(15));

        System.out.println("Estacionamento com Pilha:");
        estacionamentoPilha.entradaCarro(carro1);
        estacionamentoPilha.entradaCarro(carro2);
        estacionamentoPilha.entradaCarro(carro3);
        estacionamentoPilha.entradaCarro(carro4);
        estacionamentoPilha.estadoAtual();
        estacionamentoPilha.consultaCarro("AAA-1111");
        estacionamentoPilha.saidaCarro("AAA-1111");
        estacionamentoPilha.estadoAtual();

        System.out.println("\nEstacionamento com Fila:");
        estacionamentoFila.entradaCarro(carro1);
        estacionamentoFila.entradaCarro(carro2);
        estacionamentoFila.entradaCarro(carro3);
        estacionamentoFila.entradaCarro(carro4);
        estacionamentoFila.estadoAtual();
        estacionamentoPilha.saidaCarro("AAA-1111");
        estacionamentoFila.consultaCarro("BBB-2222");
        estacionamentoFila.consultaCarro("CCC-3333");
        estacionamentoFila.saidaCarro();
        estacionamentoFila.estadoAtual();
    }
}
