package sample.controllers;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import sample.Cell;
import sample.actions.MoveJson;
import sample.actions.ShootJson;
import sample.events.Points;
import sample.events.Walls;
import sample.instruments.JsonReader2;
import sample.instruments.JsonWriter2;
import sample.moonRiders.MoonRider1Json;
import sample.moonRiders.MoonRider2Json;

public class ClientControllerJson {
    public static int d = 0;
    public String queue;
    public static Stage stage = new Stage();
    int[][] walls = new int[14][2];
    public static Cell moonRider2 = Cell.A8;
    String[][] wallsInfo = new String[14][2];
    String[] lineWalls = new String[14];

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
            if (new ShootJson().canShootPoints(textFieldPoints.getText())) {
                new ShootJson().shootDirection();
            }
        });
        MoveButton.setOnAction(actionEvent -> {
            new MoveJson().moveDirection();
        });
        goButton.setOnAction(actionEvent -> {
            try (FileReader fr = new FileReader("saved\\queue2.txt")) {
                BufferedReader reader = new BufferedReader(fr);
                queue = reader.readLine();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            if (Integer.parseInt(queue) % 2 == 0) {
                if (d == 1) {
                    if (ControllerDirectionJson.direction.equals("up")) {
                        for (int i = 0; i < moonRider2.x; i++) {
                            if (new Walls().canShoot((moonRider2.x - 1) - i, moonRider2.y) || new ShootJson().win2((moonRider2.x - 1) - i, moonRider2.y)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x - 1) - i);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x - 1) - i);
                            }
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("down")) {
                        for (int i = 0; i < 7 - moonRider2.x; i++) {
                            if (new Walls().canShoot((moonRider2.x + 1) + i, moonRider2.y) || new ShootJson().win2((moonRider2.x + 1) + i, moonRider2.y)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x + 1) + i);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider2.y, (moonRider2.x + 1) + i);
                            }
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("left")) {
                        for (int i = 0; i < moonRider2.y; i++) {
                            if (new Walls().canShoot(moonRider2.x, (moonRider2.y - 1) - i) || new ShootJson().win2(moonRider2.x, (moonRider2.y - 1) - i)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y - 1) - i, moonRider2.x);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider2.y - 1) - i, moonRider2.x);
                            }
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("right")) {
                        for (int i = 0; i < 7 - moonRider2.y; i++) {
                            if (new Walls().canShoot(moonRider2.x, (moonRider2.y + 1) + i) || new ShootJson().win2(moonRider2.x, (moonRider2.y + 1) + i)) {
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
                    if (ControllerDirectionJson.direction.equals("up")) {
                        if (new Walls().canGo(moonRider2.x - 1, moonRider2.y)) {
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                            moonRider2.x = moonRider2.x - 1;
                            moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                            System.out.println(moonRider2);
                            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("down")) {
                        if (new Walls().canGo(moonRider2.x + 1, moonRider2.y)) {
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                            moonRider2.x = moonRider2.x + 1;
                            moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                            System.out.println(moonRider2);
                            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("left")) {
                        if (new Walls().canGo(moonRider2.x, moonRider2.y - 1)) {
                        } else {
                            gridPane.add(new ImageView(new Image("File:pic/Moon.png")), moonRider2.y, moonRider2.x);
                            moonRider2.y = moonRider2.y - 1;
                            moonRider2 = Cell.findBy(moonRider2.x, moonRider2.y);
                            System.out.println(moonRider2);
                            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), moonRider2.y, moonRider2.x);
                        }
                    }
                    if (ControllerDirectionJson.direction.equals("right")) {
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
                    new MoonRider2Json().setMoonRider2(moonRider2.y, moonRider2.x);
                }
                try (FileWriter writer = new FileWriter("saved\\queue2.txt", false)) {
                    writer.write(String.valueOf(Integer.parseInt(queue) + 1));
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                new JsonWriter2("queue2");
            }
        });

        updateButton.setOnAction(actionEvent -> {
            new JsonReader2("queue1", "192.168.0.194", "4321");
            new JsonReader2("wallsInfo1", "192.168.0.194", "4321");
            for (int i = 0; i != 8; i++) {
                for (int j = 0; j != 8; j++) {
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
                }
            }
            try (FileReader fr = new FileReader("saved\\wallsInfo2.txt")) {
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
                System.out.println(walls[i][0] + " " + walls[i][1]);
                wallsInfo[i][0] = String.valueOf(walls[i][0]);
                wallsInfo[i][1] = String.valueOf(walls[i][1]);
            }
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider2Json().getMoonRider2()[0], new MoonRider2Json().getMoonRider2()[1]);
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider1Json().getMoonRider1For2()[0], new MoonRider1Json().getMoonRider1For2()[1]);
        });

        for (int i = 0; i != 8; i++) {
            for (int j = 0; j != 8; j++) {
                gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
            }
        }
    }
}