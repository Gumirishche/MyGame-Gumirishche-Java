package sample.controllers;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client;
import sample.Server;

public class HostMenuController {
Stage stage =new Stage();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField portHost;

    @FXML
    private Button nextButton;

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

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/filesFXML/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            HostOrClientController.stage.close();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
