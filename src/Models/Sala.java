package Models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(propOrder = {"id","ubicacion","capacidadMaxima","recursos","estado", "calificaciones","agendaServicio"})
public class Sala {
    private static int cantidadSalas=0;

    private String id;
    private String ubicacion;
    private int capacidadMaxima;
    private String recursos;
    private String estado="Activa";//TODO: Passarlo a un enum?
    private ArrayList<Calificacion> calificaciones =new ArrayList<>();
    private ArrayList<Horario> agendaServicio=new ArrayList<>();

    public Sala( String ubicacion, int capacidadMaxima, String recursos) {
        cantidadSalas++;
        this.id = "SAL-"+cantidadSalas;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.recursos = recursos;
    }

    public Sala() {}

    public void agregarHorario(Horario horario){
        if (!validarHorario(horario))
            agendaServicio.add(horario);
    }

    public void eliminarHorario(Horario pHorario){
                agendaServicio.remove(pHorario);

    }

    public boolean validarHorario(Horario pHorario){
        for (Horario horario : agendaServicio) {
            if (horario==pHorario)
                return true;
        }
        return false;
    }
    @XmlElement(name="agendaServicio")
    public ArrayList<Horario> getAgendaServicio() {
        return agendaServicio;
    }

    public void setAgendaServicio(ArrayList<Horario> pAgendaServicio) {
        agendaServicio = pAgendaServicio;
    }


    public static int getCantidadSalas() {
        return cantidadSalas;
    }

    public static void setCantidadSalas(int cantidadSalas) {
        Sala.cantidadSalas = cantidadSalas;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @XmlElement
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    @XmlElement
    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    @XmlElement
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlElement
    public int getCalificaciones() {
        if (calificaciones.isEmpty())
            return 100;
        else{
            int res=0;
            for (Calificacion calificacion:
                    calificaciones) {
                res+=calificacion.nota;
            }
            return res/calificaciones.size();
        }

    }

    public void setCalificaciones(ArrayList calificaciones) {
        this.calificaciones = calificaciones;
    }

    public void agregarCalificacion(int nota, String codigo){
        if (!existeCalificacion(codigo))
            calificaciones.add(new Calificacion(nota, codigo));

    }

    public boolean existeCalificacion(String codigo) {
        for (Calificacion calificacion:calificaciones) {
            if (codigo==calificacion.codigo)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sala " + id;
    }
}
