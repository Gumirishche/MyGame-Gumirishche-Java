package sample.actions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.ClientControllerJson;
import sample.controllers.ControllerJson;
import sample.controllers.HostOrClientController;

import java.io.IOException;

public class MoveJson {
    public static Stage stage = new Stage();

    public void moveDirection() {
        System.out.print("Move");
        if (HostOrClientController.client == 1) {
            ControllerJson.d = 2;
        } else {
            ClientControllerJson.d = 2;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/filesFXML/directionJson.fxml"));

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