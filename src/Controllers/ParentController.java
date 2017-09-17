package Controllers;


import Views.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

public class ParentController {
    public MenuItem menuAgregarEstudiante;
    public void menuAgregarEstudiante(ActionEvent actionEvent) {
        try {
            Main.getInstance().replaceSceneContent("/Views/JavaFX/estudiantes.fxml");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
