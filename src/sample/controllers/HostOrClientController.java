package sample.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.actions.Queue;
import sample.actions.QueueJson;
import sample.events.Walls;
import sample.moonRiders.MoonRider1;
import sample.moonRiders.MoonRider1Json;
import sample.moonRiders.MoonRider2;
import sample.moonRiders.MoonRider2Json;

public class HostOrClientController {
    public static int client;
    public static Stage stage = new Stage();

    @FXML
    private Button hostButton;

    @FXML
    private Button clientButton;

    @FXML
    private Button hostButton1;

    @FXML
    private Button clientButton1;

    @FXML
    void initialize() {
        hostButton.setOnAction(actionEvent -> {
            new Queue().Queue();
            new Walls().wallsPosition();
            new MoonRider1().defaultMoonRider1();
            client = 1;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            MainWindowController.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        hostButton1.setOnAction(actionEvent -> {
            new QueueJson().QueueJson();
            new Walls().wallsPosition();
            new MoonRider1Json().defaultMoonRider1();
            client = 1;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/hostJson.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            MainWindowController.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        clientButton.setOnAction(actionEvent -> {
            client = 2;
            new MoonRider2().defaultMoonRider2();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/client.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            MainWindowController.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        clientButton1.setOnAction(actionEvent -> {
            client = 2;
            new MoonRider2Json().defaultMoonRider2();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/clientJson.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            MainWindowController.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}