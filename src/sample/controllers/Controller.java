package sample.controllers;


import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.Cell;
import sample.events.Points;
import sample.events.Walls;
import sample.actions.Move;
import sample.actions.Shoot;
import sample.server.Server20;

import javax.swing.*;

public class Controller {
    public static int d = 0;
    public String direction = "";
    public static Stage stage = new Stage();
    public static int[][] walls = new int[14][2];
    public Cell moonRider1 = Cell.R1;
    private int end,port=0;
    String inform;
    public static String[][] wallsInfo=new String[14][2];
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
    private TextField textFieldPoints;


    @FXML
    void initialize() {
        textFieldPoints.setText(String.valueOf(new Points().getPoints()));
        try (FileReader fr = new FileReader("saves\\playerOneHostPort.txt")) {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            port = Integer.parseInt(line);;
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }


        ShootButton.setOnAction(actionEvent -> {
            if (new Shoot().canShootPoints(textFieldPoints.getText())) {
                new Shoot().shootDirection();

            }
        });
        MoveButton.setOnAction(actionEvent -> {
            new Move().moveDirection();
        });
        goButton.setOnAction(actionEvent -> {
            if (d == 1) {
                if (ControllerDirection.direction.equals("up")) {
                    for (int i = 0; i < moonRider1.x; i++) {
                        if (new Walls().canShoot((moonRider1.x - 1) - i, moonRider1.y)|| new Shoot().win((moonRider1.x - 1) - i, moonRider1.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                            end = (moonRider1.x - 1) - i;
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                            end = (moonRider1.x - 1) - i;
                        }
                    }

                    /*for (int i = 0; i <= end; i++) {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider1.y, (moonRider1.x - 1) - i);
                    }*/
                }
                if (ControllerDirection.direction.equals("down")) {
                    for (int i = 0; i < 7 - moonRider1.x; i++) {
                        if (new Walls().canShoot((moonRider1.x + 1) + i, moonRider1.y)|| new Shoot().win((moonRider1.x + 1) + i, moonRider1.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("left")) {
                    for (int i = 0; i < moonRider1.y; i++) {
                        if (new Walls().canShoot(moonRider1.x, (moonRider1.y - 1) - i)|| new Shoot().win(moonRider1.x, (moonRider1.y - 1) - i)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("right")) {
                    for (int i = 0; i < 7 - moonRider1.y; i++) {
                        if (new Walls().canShoot(moonRider1.x, (moonRider1.y + 1) + i)|| new Shoot().win(moonRider1.x, (moonRider1.y + 1) + i)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y + 1) + i, moonRider1.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y + 1) + i, moonRider1.x);
                        }
                    }
                }
                textFieldPoints.setText(String.valueOf(new Points().getPoints()));
                d = 0;
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
                textFieldPoints.setText(String.valueOf(new Points().getPoints()));
                d = 0;
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
            wallsInfo[i][0] = String.valueOf(walls[i][0]);
            wallsInfo[i][1] = String.valueOf(walls[i][1]);
        }
        try(FileWriter writer = new FileWriter("saves\\wallsInfo.txt", false))
        {
            // запись всей строки
            for(int i=0;i<14;i++){
            writer.write(wallsInfo[i][0]+","+wallsInfo[i][1]+" ");
            writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), 6, 0);
        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), 0, 7);
    }
}