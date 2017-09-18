package Models;

public class Sala {
    private static int cantidadSalas=0;

    private String id;
    private String ubicacion;
    private int capacidadMaxima;
    private String recursos;
    private String estado="Activa";//TODO: Passarlo a un enum?
    private int calificacion=100;

    public Sala( String ubicacion, int capacidadMaxima, String recursos) {
        cantidadSalas++;
        this.id = "SAL-"+cantidadSalas;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.recursos = recursos;
    }

    public Sala() {}

    public static int getCantidadSalas() {
        return cantidadSalas;
    }

    public static void setCantidadSalas(int cantidadSalas) {
        Sala.cantidadSalas = cantidadSalas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
