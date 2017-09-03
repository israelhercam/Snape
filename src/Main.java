import Models.Estudiante;
import Models.Wrappers.Estudiantes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage stage;


    public static void main(String[] args) throws Exception{
        Estudiantes estudiantes=new Estudiantes();
        estudiantes.loadFromXML();

        estudiantes.add(new Estudiante("asd",123456,"carrera","correo",12345));
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/Views/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        //TODO: Buscar afterburner.fx
    }


}
