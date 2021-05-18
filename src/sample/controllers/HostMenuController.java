package sample.controllers;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Client;

public class HostMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField portHost;

    @FXML
    void initialize() {
        portHost.setOnAction(actionEvent ->  {
            try(FileWriter writer = new FileWriter("saves\\playerOneHostPort.txt", false))
            {
                // запись всей строки
                writer.write(portHost.getText());
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

            new Client();
        });
    }
}
