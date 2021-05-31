package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;
import sample.actions.Queue;
import sample.events.Walls;
import sample.moonRiders.MoonRider1;
import sample.moonRiders.MoonRider2;

public class HostOrClientController {
    public static int client;
    public static Stage stage=new Stage();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button hostButton;

    @FXML
    private Button clientButton;

    @FXML
    void initialize() {
       hostButton.setOnAction(actionEvent -> {
           new Queue().queue();
           new Walls().wallsPosition();
           new MoonRider1().defaultMoonRider1();
           client=1;
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
       clientButton.setOnAction(actionEvent -> {
           client=2;
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
    }
}