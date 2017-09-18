package Controllers;

import Models.Horario;
import Models.Turno;
import Utils.Utils;
import Views.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioController {
    public String id;
    public TitledPane tpnSala;
    public TableView tblSalas;
    public TableColumn tbcDia;
    public TableColumn tbcInicio;
    public TableColumn tbcFin;
    public ComboBox cBoxDia;
    public Spinner spnInicioHora;
    public Spinner spnInicioMinutos;
    public Spinner spnFinHora;
    public Spinner spnFinMinutos;
    public Horario horario;
    public Button btnEnviar;

    public void initialize(){
        initData();

        tbcDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
        tbcInicio.setCellValueFactory(new PropertyValueFactory<>("inicio"));
        tbcFin.setCellValueFactory(new PropertyValueFactory<>("fin"));
        poblarDias();
    }

    public void initData() {
        this.id=SalasController.id;
        tpnSala.setText("Sala: "+id);
        horario=new Horario(id);
    }

    public void agregarTurno(ActionEvent actionEvent) {
        if (cBoxDia.getValue()==null
                ||spnInicioHora.getValue()==spnFinHora.getValue()
                &&spnInicioMinutos.getValue()==spnFinMinutos.getValue()){
            Utils.mostrarError("Error","Error en los datos ingresados","Revise los datos ingresados!");
            return;
        }
        horario.agregarTurno(new Turno(((DayOfWeek) cBoxDia.getValue()),
                LocalTime.of((int)spnInicioHora.getValue(),(int)spnInicioMinutos.getValue()),
                LocalTime.of((int)spnFinHora.getValue(),(int)spnFinMinutos.getValue())));
        refrescarLista();

    }

    private void poblarDias(){
        for (DayOfWeek dia: DayOfWeek.values()) {
            cBoxDia.getItems().add(dia);
//dia.getDisplayName(TextStyle.FULL, new Locale("es","CR")
        }
    }

    public void enviarHorario(ActionEvent actionEvent) throws Exception {

        Main.getInstance().horarios.add(horario);
        Main.getInstance().horarios.saveInXML();
        Stage stage = (Stage) btnEnviar.getScene().getWindow();
        stage.close();
    }

    public void refrescarLista(){
        ObservableList<Turno> list = FXCollections.observableArrayList(horario.getTurnos());
        tblSalas.setItems(list);
    }
}
