package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("filesFXML/mainWindow.fxml"));
        stage.setTitle("Moon Drivers");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
