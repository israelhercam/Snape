package Models;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public class Reservacion {
    String asunto;
    String idSala;
    String estado;
    List<Participante> participantes;
    LocalDateTime fecha;
    Period tiempo;

    //TODO: Revisar si la fecha esta bien y/o exportarla a otra clase
    public Reservacion(String asunto, String idSala, String estado, List<Participante> participantes, LocalDateTime fecha, Period tiempo) {
        this.asunto = asunto;
        this.idSala = idSala;
        this.estado = estado;
        this.participantes = participantes;
        this.fecha = fecha;
        this.tiempo = tiempo;

    }
}
