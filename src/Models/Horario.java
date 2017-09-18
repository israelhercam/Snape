package Models;

import Utils.Utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(propOrder = {"idSala","turnos"})
@XmlRootElement(name = "horario")
public class Horario {
    private String idSala;
    private ArrayList<Turno> turnos;

    public Horario() {
    }

    public Horario(String idSala) {
        this.idSala=idSala;
        turnos=new ArrayList<>();
    }

    @XmlElement(name="turnos")
    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    @XmlElement(name="idSala")
    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public void agregarTurno(Turno nuevo){
        if (!verificarTurno(nuevo))
            turnos.add(nuevo);
    }




    public boolean verificarTurno(Turno nuevo){
        for (Turno turno:
             turnos) {
            if (nuevo.getDia()==turno.getDia()&&(Utils.estaEnMedio(turno.getInicio(),nuevo.getInicio(),turno.getFin())
                    ||Utils.estaEnMedio(turno.getInicio(),nuevo.getFin(),turno.getFin())))
                return true;
        }
        return false;

    }
}
