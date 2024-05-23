import java.time.LocalDateTime;

public class Carro {
    private String placa;
    private LocalDateTime horarioEntrada;
    private LocalDateTime horarioSaida;

    public Carro(String placa, LocalDateTime horarioEntrada) {
        this.placa = placa;
        this.horarioEntrada = horarioEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    @Override
    public String toString() {
        return "[placa=" + placa + ", entrada=" + horarioEntrada + "]";
    }
}
