package sample.actions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controllers.Controller;

import java.io.IOException;

public class Shoot {
    public static Stage stage = new Stage();
    GridPane gridPane;

    public void shootDirection() {
        System.out.print("Shoot");
        Controller.d = 1;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/filesFXML/direction.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public boolean canShootPoints(String points) {
        return Integer.parseInt(points) == 3;
    }
}