package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    public int d = 0;
    public String direction = "";
    public static Stage stage = new Stage();
    int[][] walls = new int[14][2];
    public Cell moonRider1 = Cell.R1;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ShootButton;

    @FXML
    private Button MoveButton;

    @FXML
    private Button goButton;

    @FXML
    private GridPane gridPane;


    @FXML
    void initialize() {
        ShootButton.setOnAction(actionEvent -> {
            System.out.print("Shoot");
            d = 1;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/direction.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        MoveButton.setOnAction(actionEvent -> {
            System.out.print("Move");
            d = 2;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/direction.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
        goButton.setOnAction(actionEvent -> {
            if (d == 1) {
                this.direction = direction;
                if (ControllerDirection.direction.equals("up")) {
                    for (int i = 0; i < moonRider1.x; i++) {
                        if (new Walls().canShoot((moonRider1.x - 1) - i, moonRider1.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("down")) {
                    for (int i = 0; i < 7 - moonRider1.x; i++) {
                        if (new Walls().canShoot((moonRider1.x + 1) + i, moonRider1.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("left")) {
                    for (int i = 0; i < moonRider1.y; i++) {
                        if (new Walls().canShoot(moonRider1.x, (moonRider1.y - 1) - i)) {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("right")) {
                    for (int i = 0; i < 7 - moonRider1.y; i++) {
                        if (new Walls().canShoot(moonRider1.x, (moonRider1.y + 1) + i)) {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), (moonRider1.y + 1) + i, moonRider1.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/shot.png")), (moonRider1.y + 1) + i, moonRider1.x);
                        }
                    }
                }
            } else if (d == 2) {
                this.direction = direction;
                if (ControllerDirection.direction.equals("up")) {
                    if (new Walls().canGo(moonRider1.x - 1, moonRider1.y)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider1.y, moonRider1.x);
                        moonRider1.x = moonRider1.x - 1;
                        moonRider1 = Cell.findBy(moonRider1.x, moonRider1.y);
                        System.out.println(moonRider1);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider1.y, moonRider1.x);
                    }
                }
                if (ControllerDirection.direction.equals("down")) {
                    if (new Walls().canGo(moonRider1.x + 1, moonRider1.y)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider1.y, moonRider1.x);
                        moonRider1.x = moonRider1.x + 1;
                        moonRider1 = Cell.findBy(moonRider1.x, moonRider1.y);
                        System.out.println(moonRider1);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider1.y, moonRider1.x);
                    }
                }
                if (ControllerDirection.direction.equals("left")) {
                    if (new Walls().canGo(moonRider1.x, moonRider1.y - 1)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider1.y, moonRider1.x);
                        moonRider1.y = moonRider1.y - 1;
                        moonRider1 = Cell.findBy(moonRider1.x, moonRider1.y);
                        System.out.println(moonRider1);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider1.y, moonRider1.x);
                    }
                }
                if (ControllerDirection.direction.equals("right")) {
                    if (new Walls().canGo(moonRider1.x, moonRider1.y + 1)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider1.y, moonRider1.x);
                        moonRider1.y = moonRider1.y + 1;
                        moonRider1 = Cell.findBy(moonRider1.x, moonRider1.y);
                        System.out.println(moonRider1);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider1.y, moonRider1.x);
                    }
                }
            }
        });
        for (int i = 0; i != 8; i++) {
            for (int j = 0; j != 8; j++) {
                gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
            }
        }
        walls = new Walls().wallsPosition();
        for (int i = 0; i < 14; i++) {
            gridPane.add(new ImageView(new Image("File:pic/Walls.png")), walls[i][0], walls[i][1]);
        }
        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), 7, 0);
        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), 0, 7);
    }
}