package Models.Wrappers;

import Models.Participante;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;

/**
 * Clase de reservaciones.
 * Esta clase sirve de contenedor de las reservaciones, ademas es necesaria para la JABX.
 *
 * @author Esteban Esquivel
 * @author Israel Padilla
 * @author Israel
 */

@XmlRootElement(name = "reservaciones")
public class Reservaciones {

    private static ArrayList<Participante> lista=new ArrayList<>();

    @XmlElement(name = "reservacion")
    public ArrayList<Participante> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Participante> lista) {
        this.lista = lista;
    }

    //Terminan los Getters y Setters

    /**
     * Añade un participante a la lista de estudiantes.
     * @param participante Estudiante a añadir.
     */
    public void add(Participante participante){
        if (!verificarEstudiante(participante))
            lista.add(participante);
    }

    //TODO: Arreglar esto, seria por fecha diferente y sala diferente
    /**
     * Verifica si el participante tiene un CORREO diferente.
     * @param participanteVerificado Estudiante que se busca en la lista.
     * @return
     */
    public boolean verificarEstudiante(Participante participanteVerificado){
        for (Participante participanteVerificar:
             getLista()) {
            if (participanteVerificado.getCorreo()==participanteVerificar.getCorreo())
                return true;
        }
        return false;
    }

    /**
     * Guarda en un XML la lista de estudiantes
     * @throws Exception
     */
    public void saveInXML() throws Exception {

        JAXBContext contextObj = JAXBContext.newInstance(Reservaciones.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshallerObj.marshal(this, new File("ReservacionesDB.xml"));

    }

    /**
     * Carga de un XML la lista de estudiantes
     * @throws JAXBException
     */
    public void loadFromXML() throws JAXBException {
        File file = new File( "ReservacionesDB.xml" );
        JAXBContext jaxbContext = JAXBContext.newInstance( Reservaciones.class );

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Reservaciones estudiantes = (Reservaciones)jaxbUnmarshaller.unmarshal( file );
        setLista(estudiantes.getLista());
    }

}
