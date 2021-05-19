package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.actions.Move;
import sample.actions.Shoot;

public class ControllerDirection {
    public static String direction = "";

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
            if (HostOrClientController.client == 1) {
                if (Controller.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            } else {
                if (ClientController.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            }
        });
        DirectionUpButton.setOnAction(actionEvent -> {
            direction = "up";
            if (HostOrClientController.client == 1) {
                if (Controller.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            } else {
                if (ClientController.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            }
        });
        DirectionDownButton.setOnAction(actionEvent -> {
            direction = "down";
            if (HostOrClientController.client == 1) {
                if (Controller.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            } else {
                if (ClientController.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            }
        });
        DirectionLeftButton.setOnAction(actionEvent -> {
            direction = "left";
            if (HostOrClientController.client == 1) {
                if (Controller.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            } else {
                if (ClientController.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            }
        });
        DirectionRightButton.setOnAction(actionEvent -> {
            direction = "right";
            if (HostOrClientController.client == 1) {
                if (Controller.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            } else {
                if (ClientController.d == 1) {
                    Shoot.stage.close();
                } else {
                    Move.stage.close();
                }
            }
        });
    }
}

