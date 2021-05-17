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

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    public int d = 0;
    public String direction="";
    public static Stage stage = new Stage();
    int[][] map=new int[8][8];
    public Cell moonRider1=Cell.R1;
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
    private Pane c3;

    @FXML
    private Pane a2;

    @FXML
    private Pane a3;

    @FXML
    private Pane a4;

    @FXML
    private Pane a5;

    @FXML
    private Pane a6;

    @FXML
    private Pane a7;

    @FXML
    private Pane a8;

    @FXML
    private Pane b1;

    @FXML
    private Pane c1;

    @FXML
    private Pane d1;

    @FXML
    private Pane e1;

    @FXML
    private Pane f1;

    @FXML
    private Pane g1;

    @FXML
    private Pane r1;

    @FXML
    private Pane b2;

    @FXML
    private Pane b3;

    @FXML
    private Pane b4;

    @FXML
    private Pane b5;

    @FXML
    private Pane b6;

    @FXML
    private Pane b7;

    @FXML
    private Pane b8;

    @FXML
    private Pane c2;

    @FXML
    private Pane a1;

    @FXML
    private Pane c4;

    @FXML
    private Pane c5;

    @FXML
    private Pane c6;

    @FXML
    private Pane c7;

    @FXML
    private Pane c8;

    @FXML
    private Pane d2;

    @FXML
    private Pane d3;

    @FXML
    private Pane d4;

    @FXML
    private Pane d5;

    @FXML
    private Pane d6;

    @FXML
    private Pane d7;

    @FXML
    private Pane d8;

    @FXML
    private Pane e8;

    @FXML
    private Pane f8;

    @FXML
    private Pane g8;

    @FXML
    private Pane r8;

    @FXML
    private Pane e7;

    @FXML
    private Pane e6;

    @FXML
    private Pane e5;

    @FXML
    private Pane e4;

    @FXML
    private Pane e3;

    @FXML
    private Pane e2;

    @FXML
    private Pane f2;

    @FXML
    private Pane g2;

    @FXML
    private Pane r2;

    @FXML
    private Pane f7;

    @FXML
    private Pane f6;

    @FXML
    private Pane f5;

    @FXML
    private Pane f4;

    @FXML
    private Pane f3;

    @FXML
    private Pane g3;

    @FXML
    private Pane r3;

    @FXML
    private Pane g4;

    @FXML
    private Pane g5;

    @FXML
    private Pane g6;

    @FXML
    private Pane g7;

    @FXML
    private Pane r4;

    @FXML
    private Pane r5;

    @FXML
    private Pane r6;

    @FXML
    private Pane r7;


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
            if(d==1){}
            else if(d==2){
                this.direction=direction;
                if(ControllerDirection.direction.equals("up")){
                    moonRider1.x=moonRider1.x-1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/moonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("down")){
                    moonRider1.x=moonRider1.x+1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/moonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("left")){
                    moonRider1.y=moonRider1.y-1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/moonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("right")){
                    moonRider1.y=moonRider1.y+1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/moonRider.png")),moonRider1.y,moonRider1.x);
                }
            }
        });

    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
}