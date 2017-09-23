package Models;

import Models.Adapters.LocalDateAdapter;
import Models.Adapters.LocalTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@XmlType(propOrder = {"id","idSala","idOrganizador","asunto","estado","fecha","horaInicio","horaFin","participantes"})
@XmlRootElement(name = "reserva")
public class Reserva {
    static int cantReservas=0;
    int id;
    String asunto;
    String idSala;
    int idOrganizador;
    String estado;
    List<Participante> participantes;
    LocalDate fecha;
    LocalTime horaInicio;
    LocalTime horaFin;

    public Reserva() {
    }

    //TODO: Revisar si la fecha esta bien y/o exportarla a otra clase


    public Reserva(String asunto, String idSala, String estado, List<Participante> participantes, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        cantReservas++;
        this.id=cantReservas;
        this.asunto = asunto;
        this.idSala = idSala;
        this.estado = estado;
        this.participantes = participantes;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    @XmlElement
    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int pIdOrganizador) {
        idOrganizador = pIdOrganizador;
    }

    public static int getCantReservas() {
        return cantReservas;
    }

    public static void setCantReservas(int pCantReservas) {
        cantReservas = pCantReservas;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int pId) {
        id = pId;
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
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    @XmlElement
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    @XmlElement
    @XmlJavaTypeAdapter(LocalTimeAdapter.class)
    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getCantidadParticipantes(){
        return participantes.size();
    }
}
