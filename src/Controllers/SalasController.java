package Controllers;

import Models.Sala;
import Models.Wrappers.Salas;
import Utils.Utils;
import Views.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalasController {
    public TableColumn tbcId;
    public TableColumn tbcUbicacion;
    public TableColumn tbcCapacidad;
    public TableColumn tbcRecursos;
    public TableColumn tbcEstado;
    public TableColumn tbcCalificacion;
    public TableView<Sala> tblSalas;
    public TextField txtUbicacion;
    public TextField txtCapacidad;
    public TextField txtRecursos;

    Salas salas = Main.getInstance().salas;


    public void initialize(){

        tbcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        tbcCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidadMaxima"));
        tbcRecursos.setCellValueFactory(new PropertyValueFactory<>("recursos"));
        tbcEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tbcCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));

        refrescarLista();
    }
    public void agregarSala(ActionEvent actionEvent) throws Exception {

        if (!Utils.validarNumero(txtCapacidad.getText())
                ||txtUbicacion.getText().isEmpty()
                ||txtRecursos.getText().isEmpty()){
            Utils.mostrarError("Error","Error en los datos ingresados","Revise los datos ingresados!");
            return;
        }
        Sala nueva=new Sala(txtUbicacion.getText(),Integer.parseInt(txtCapacidad.getText()),txtRecursos.getText());

        txtUbicacion.setText("");
        txtCapacidad.setText("");
        txtRecursos.setText("");

        salas.add(nueva);
        salas.saveInXML();
        refrescarLista();

    }


    public void refrescarLista(){
        ObservableList<Sala> list = FXCollections.observableArrayList(salas.getLista());
        tblSalas.setItems(list);
    }

}
