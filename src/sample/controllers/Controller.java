package sample.controllers;


import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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

public class Controller {
    public static int d = 0;
    public String queue;
    public static Stage stage = new Stage();
    public static int[][] walls = new int[14][2];
    public Cell moonRider1 = Cell.R1;
    public static String[][] wallsInfo = new String[14][2];
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
            if (new Shoot().canShootPoints(textFieldPoints.getText())) {
                new Shoot().shootDirection();
            }
        });
        MoveButton.setOnAction(actionEvent -> {
            new Move().moveDirection();
        });
        goButton.setOnAction(actionEvent -> {
            try (FileReader fr = new FileReader("saves\\queue.txt")) {
                BufferedReader reader = new BufferedReader(fr);
                queue = reader.readLine();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            if (Integer.parseInt(queue) % 2 != 0) {
                if (d == 1) {
                    try {
                        URL url = new URL("http://127.0.0.1:1234/wallsInfo2.txt");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

                        File f1 = new File("saves\\wallsInfo1.txt");
                        FileOutputStream fw = new FileOutputStream(f1);

                        byte[] b = new byte[1024];
                        int count = 0;
                        System.out.println("Host ????????????!");

                        while ((count = bis.read(b)) != -1)
                            fw.write(b, 0, count);
                        fw.close();
                    } catch (IOException ex) {
                    }
                    if (ControllerDirection.direction.equals("up")) {
                        for (int i = 0; i < moonRider1.x; i++) {
                            if (new Walls().canShoot((moonRider1.x - 1) - i, moonRider1.y) || new Shoot().win1((moonRider1.x - 1) - i, moonRider1.y)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x - 1) - i);
                            }
                        }
                    }
                    if (ControllerDirection.direction.equals("down")) {
                        for (int i = 0; i < 7 - moonRider1.x; i++) {
                            if (new Walls().canShoot((moonRider1.x + 1) + i, moonRider1.y) || new Shoot().win1((moonRider1.x + 1) + i, moonRider1.y)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), moonRider1.y, (moonRider1.x + 1) + i);
                            }
                        }
                    }
                    if (ControllerDirection.direction.equals("left")) {
                        for (int i = 0; i < moonRider1.y; i++) {
                            if (new Walls().canShoot(moonRider1.x, (moonRider1.y - 1) - i) || new Shoot().win1(moonRider1.x, (moonRider1.y - 1) - i)) {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                                break;
                            } else {
                                gridPane.add(new ImageView(new Image("File:pic/Shot.png")), (moonRider1.y - 1) - i, moonRider1.x);
                            }
                        }
                    }
                    if (ControllerDirection.direction.equals("right")) {
                        for (int i = 0; i < 7 - moonRider1.y; i++) {
                            if (new Walls().canShoot(moonRider1.x, (moonRider1.y + 1) + i) || new Shoot().win1(moonRider1.x, (moonRider1.y + 1) + i)) {
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
                    new MoonRider1().setMoonRider1(moonRider1.y, moonRider1.x);
                    try {
                        URL url = new URL("http://192.168.0.194:1234/wallsInfo2.txt");
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

                        File f1 = new File("saves\\wallsInfo1.txt");
                        FileOutputStream fw = new FileOutputStream(f1);

                        byte[] b = new byte[1024];
                        int count = 0;

                        while ((count = bis.read(b)) != -1)
                            fw.write(b, 0, count);

                        fw.close();
                        System.out.println("Host ????????????!");
                    } catch (IOException ex) {
                    }
                }
                try (FileWriter writer = new FileWriter("saves\\queue.txt", false)) {
                    writer.write(String.valueOf(Integer.parseInt(queue) + 1));
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        updateButton.setOnAction(actionEvent -> {
            try {
                URL url = new URL("http://192.168.0.194:1234/queue.txt");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

                File f1 = new File("saves\\queue.txt");
                FileOutputStream fw = new FileOutputStream(f1);

                byte[] b = new byte[1024];
                int count = 0;

                while ((count = bis.read(b)) != -1)
                    fw.write(b, 0, count);
                fw.close();
                System.out.println("Host ????????????!");
            } catch (IOException ex) {
            }
            for (int i = 0; i != 8; i++) {
                for (int j = 0; j != 8; j++) {
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
                }
            }
            try (FileReader fr = new FileReader("saves\\wallsInfo1.txt")) {
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
                if (walls[i][0] != 8 || walls[i][1] != 8) {
                    gridPane.add(new ImageView(new Image("File:pic/Walls.png")), walls[i][0], walls[i][1]);
                }
                wallsInfo[i][0] = String.valueOf(walls[i][0]);
                wallsInfo[i][1] = String.valueOf(walls[i][1]);
            }
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider2().getMoonRider2For1()[0], new MoonRider2().getMoonRider2For1()[1]);
            gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")), new MoonRider1().getMoonRider1()[0], new MoonRider1().getMoonRider1()[1]);
        });
        for (int i = 0; i != 8; i++) {
            for (int j = 0; j != 8; j++) {
                gridPane.add(new ImageView(new Image("File:pic/Moon.png")), i, j);
            }
        }
    }
}