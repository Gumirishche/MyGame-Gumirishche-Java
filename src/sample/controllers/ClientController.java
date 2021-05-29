package sample.controllers;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
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
import sample.moonRiders.MoonRider1;
import sample.moonRiders.MoonRider2;
import sample.server.Server20;

import javax.swing.*;

public class ClientController {
    public static int d = 0;
    public String direction = "";
    public static Stage stage = new Stage();
    int[][] walls = new int[14][2];
    public static Cell moonRider2 = Cell.A8;
    private int end, port;
    String[][] wallsInfo = new String[14][2];
    String[] lineWalls = new String[14];
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
    private Button updateButton;


    @FXML
    void initialize() {
        textFieldPoints.setText(String.valueOf(new Points().getPoints()));

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
                    for (int i = 0; i < moonRider2.x; i++) {
                        if (new Walls().canShoot((moonRider2.x - 1) - i, moonRider2.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x - 1) - i);
                            end = (moonRider2.x - 1) - i;
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x - 1) - i);
                            end = (moonRider2.x - 1) - i;
                        }
                    }
                }
                if (ControllerDirection.direction.equals("down")) {
                    for (int i = 0; i < 7 - moonRider2.x; i++) {
                        if (new Walls().canShoot((moonRider2.x + 1) + i, moonRider2.y)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x + 1) + i);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x + 1) + i);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("left")) {
                    for (int i = 0; i < moonRider2.y; i++) {
                        if (new Walls().canShoot(moonRider2.x, (moonRider2.y - 1) - i)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y - 1) - i, moonRider2.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y - 1) - i, moonRider2.x);
                        }
                    }
                }
                if (ControllerDirection.direction.equals("right")) {
                    for (int i = 0; i < 7 - moonRider2.y; i++) {
                        if (new Walls().canShoot(moonRider2.x, (moonRider2.y + 1) + i)) {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y + 1) + i, moonRider2.x);
                            break;
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y + 1) + i, moonRider2.x);
                        }
                    }
                }
                textFieldPoints.setText(String.valueOf(new Points().getPoints()));
                d = 0;
            } else if (d == 2) {
                this.direction = direction;
                if (ControllerDirection.direction.equals("up")) {
                    if (new Walls().canGo(moonRider2.x - 1, moonRider2.y)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                        moonRider2.x = moonRider2.x - 1;
                        moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                        System.out.println(moonRider2);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                    }
                }
                if (ControllerDirection.direction.equals("down")) {
                    if (new Walls().canGo(moonRider2.x + 1, moonRider2.y)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                        moonRider2.x = moonRider2.x + 1;
                        moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                        System.out.println(moonRider2);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                    }
                }
                if (ControllerDirection.direction.equals("left")) {
                    if (new Walls().canGo(moonRider2.x, moonRider2.y - 1)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                        moonRider2.y = moonRider2.y - 1;
                        moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                        System.out.println(moonRider2);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                    }
                }
                if (ControllerDirection.direction.equals("right")) {
                    if (new Walls().canGo(moonRider2.x, moonRider2.y + 1)) {
                    } else {
                        gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                        moonRider2.y = moonRider2.y + 1;
                        moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                        System.out.println(moonRider2);
                        gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                    }
                }
                textFieldPoints.setText(String.valueOf(new Points().getPoints()));
                d = 0;
                new MoonRider2().setMoonRider2(moonRider2.y,moonRider2.x);
            }
        });

        updateButton.setOnAction(actionEvent -> {
            try {
                URL url = new URL("http://127.0.0.1:1234/wallsInfo1.txt");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

                File f1 = new File("saved\\wallsInfo2.txt");
                FileOutputStream fw = new FileOutputStream(f1);

                byte[] b = new byte[1024];
                int count = 0;

                while ((count=bis.read(b)) != -1)
                    fw.write(b,0,count);

                fw.close();
                System.out.println("Client принял!");
            } catch (IOException ex) {
            }

            for (int i = 0; i != 8; i++) {
                for (int j = 0; j != 8; j++) {
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
                }
            }
            try (FileReader fr = new FileReader("saved\\wallsInfo2.txt")) {
                // читаем посимвольно
                BufferedReader reader = new BufferedReader(fr);
                lineWalls = reader.readLine().split(" ");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            for (int i = 0; i < 14; i++) {
                walls[i][0] = Integer.parseInt(lineWalls[i].split(",")[0]);
                walls[i][1] = Integer.parseInt(lineWalls[i].split(",")[1]);
            }
            for (int i = 0; i < 14; i++) {
                if (walls[i][0] != 8 || walls[i][1] != 8)
                    gridPane.add(new ImageView(new Image("File:pic/Walls.png")), walls[i][0], walls[i][1]);
                System.out.println(walls[i][0]+" "+walls[i][1]);
                wallsInfo[i][0] = String.valueOf(walls[i][0]);
                wallsInfo[i][1] = String.valueOf(walls[i][1]);
            }
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider2().getMoonRider2()[0], new MoonRider2().getMoonRider2()[1]);
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider1().getMoonRider1()[0], new MoonRider1().getMoonRider1()[1]);
        });

        for (int i = 0; i != 8; i++) {
            for (int j = 0; j != 8; j++) {
                gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
            }
        }
    }
}