package Models;

public class Sala {
    private static int cantidadSalas=0;

    private String id;
    private String ubicacion;
    private int capacidadMaxima;
    private String recursos;
    private String estado;//TODO: Passarlo a un enum?
    private int calificacion=100;

    public Sala(String id, String ubicacion, int capacidadMaxima, String recursos) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.recursos = recursos;
    }
}
