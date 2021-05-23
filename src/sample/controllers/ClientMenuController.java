package sample.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client;

public class ClientMenuController {
    Stage stage=new Stage();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField portClient;

    @FXML
    void initialize() {
        portClient.setOnAction(actionEvent ->  {
                try(FileWriter writer = new FileWriter("saves\\playerTwoHostPort.txt", false))
                {
                    // запись всей строки
                    writer.write(portClient.getText());
                    writer.flush();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }

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
