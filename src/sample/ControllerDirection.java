package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ControllerDirection {
    public static String direction="";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button DirectionUpButton;

    @FXML
    private Button DirectionLeftButton;

    @FXML
    private Button DirectionRightButton;

    @FXML
    private Button DirectionDownButton;

    @FXML
    private Button DirectionBackButton;

    @FXML
    private static Group group;

    @FXML
    void initialize() {
        DirectionBackButton.setOnAction(actionEvent -> {
            Controller.stage.close();
        });
        DirectionUpButton.setOnAction(actionEvent -> {
            direction="up";
            Controller.stage.close();
        });
        DirectionDownButton.setOnAction(actionEvent -> {
            direction="down";
            Controller.stage.close();
        });
        DirectionLeftButton.setOnAction(actionEvent -> {
            direction="left";
            Controller.stage.close();
        });
        DirectionRightButton.setOnAction(actionEvent -> {
            direction="right";
            Controller.stage.close();
        });
    }

    public static Group getGroup() {
        return group;
    }

    public static void setGroup(Group group) {
        ControllerDirection.group = group;
    }
}

