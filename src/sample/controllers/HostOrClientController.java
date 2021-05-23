package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Main;

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
           client=1;
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/filesFXML/hostMenu.fxml"));

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
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/filesFXML/clientMenu.fxml"));

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