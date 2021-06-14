package sample.controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

public class MainWindowController {
    public static Stage stage = new Stage();

    @FXML
    private Button playButton;

    @FXML
    void initialize() {
        playButton.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/hostOrClient.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Main.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}