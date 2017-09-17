package Controllers;

import Models.Estudiante;
import Views.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EstudiantesController extends ParentController{


    public TableView<Estudiante> tblEstudiantes;
    public TextField txtNombre;
    public TableColumn tbcCarnet;
    public TableColumn tbcNombre;
    public TableColumn tbcCarrera;
    public TableColumn tbcCorreo;
    public TableColumn tbcTelefono;
    public TableColumn tbcCalificacion;


    public void initialize(){
        //Se le dice a cada TableColumn que dato va a recibir de la lista
        tbcCarnet.setCellValueFactory(new PropertyValueFactory<>("carnet"));
        tbcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tbcCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        tbcCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tbcTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tbcCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));

        //se refresca la lista
        refreshList();

    }

    /**
     * Metodo para refrecar el TableView con los estudiantes
     */
    public void refreshList(){
        ObservableList<Estudiante> list = FXCollections.observableArrayList(Main.getInstance().estudiantes.getLista());
        tblEstudiantes.setItems(list);
    }

    public void agregarEstudiante(ActionEvent actionEvent) {

    }
}
