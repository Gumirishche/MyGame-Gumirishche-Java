package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.actions.MoveJson;
import sample.actions.ShootJson;

public class ControllerDirectionJson {
    public static String direction = "";

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
    void initialize() {
        DirectionBackButton.setOnAction(actionEvent -> {
            if (HostOrClientController.client == 1) {
                if (ControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            } else {
                if (ClientControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            }
        });
        DirectionUpButton.setOnAction(actionEvent -> {
            direction = "up";
            if (HostOrClientController.client == 1) {
                if (ControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            } else {
                if (ClientControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            }
        });
        DirectionDownButton.setOnAction(actionEvent -> {
            direction = "down";
            if (HostOrClientController.client == 1) {
                if (ControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            } else {
                if (ClientControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            }
        });
        DirectionLeftButton.setOnAction(actionEvent -> {
            direction = "left";
            if (HostOrClientController.client == 1) {
                if (ControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            } else {
                if (ClientControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            }
        });
        DirectionRightButton.setOnAction(actionEvent -> {
            direction = "right";
            if (HostOrClientController.client == 1) {
                if (ControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            } else {
                if (ClientControllerJson.d == 1) {
                    ShootJson.stage.close();
                } else {
                    MoveJson.stage.close();
                }
            }
        });
    }
}