package Models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@XmlType(propOrder = {"idSala","asunto","estado","fecha","tiempo","participantes"})
@XmlRootElement(name = "reservacion")
public class Reservacion {
    String asunto;
    String idSala;
    String estado;
    List<Participante> participantes;
    LocalDateTime fecha;
    Period tiempo;

    public Reservacion() {
    }

    //TODO: Revisar si la fecha esta bien y/o exportarla a otra clase
    public Reservacion(String asunto, String idSala, String estado, List<Participante> participantes, LocalDateTime fecha, Period tiempo) {
        this.asunto = asunto;
        this.idSala = idSala;
        this.estado = estado;
        this.participantes = participantes;
        this.fecha = fecha;
        this.tiempo = tiempo;

    }


    @XmlElement
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @XmlElement
    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement
    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @XmlElement
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @XmlElement
    public Period getTiempo() {
        return tiempo;
    }

    public void setTiempo(Period tiempo) {
        this.tiempo = tiempo;
    }
}
