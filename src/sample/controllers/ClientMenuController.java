package sample.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Client;

public class ClientMenuController {

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

                new Client();
        });
    }
}
