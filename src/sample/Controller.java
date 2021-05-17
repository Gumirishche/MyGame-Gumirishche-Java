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
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")),moonRider1.y,moonRider1.x);
                    moonRider1.x=moonRider1.x-1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("down")){
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")),moonRider1.y,moonRider1.x);
                    moonRider1.x=moonRider1.x+1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("left")){
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")),moonRider1.y,moonRider1.x);
                    moonRider1.y=moonRider1.y-1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")),moonRider1.y,moonRider1.x);
                }
                if(ControllerDirection.direction.equals("right")){
                    gridPane.add(new ImageView(new Image("File:pic/Moon.png")),moonRider1.y,moonRider1.x);
                    moonRider1.y=moonRider1.y+1;
                    moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
                    System.out.println(moonRider1);
                    gridPane.add(new ImageView(new Image("File:pic/MoonRider.png")),moonRider1.y,moonRider1.x);
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