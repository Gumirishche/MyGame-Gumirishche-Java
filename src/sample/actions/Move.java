package sample.actions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.ClientController;
import sample.controllers.Controller;
import sample.controllers.HostOrClientController;

import java.io.IOException;

public class Move {
    public static Stage stage = new Stage();

    public void moveDirection() {
        System.out.print("Move");
        if (HostOrClientController.client == 1) {
            Controller.d = 2;
        } else {
            ClientController.d = 2;
        }
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
}
