package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class Map extends Rectangle {
    GridPane gridPane=new Controller().getGridPane();
    public Cell moonRider1=Cell.R1;
    public Cell moonRider2=Cell.A8;
    String direction;
    private boolean markMoonRider1=false;
    private boolean markMoonRider2=false;
    private boolean markWall=false;

    public void goMoonRider(String direction){
        this.direction=direction;
        System.out.println(this.direction);
        if(this.direction.equals("up")){
            moonRider1.x=moonRider1.x-1;
            moonRider1=Cell.findBy(moonRider1.x,moonRider1.y);
            System.out.println(moonRider1);
            gridPane.getChildren().add(new ImageView(new Image("File:pic/moonRider.png")));
        }
        else if(this.direction.equals("down")){

        }
    }

    public Map(){
        this.markMoonRider1=false;
        this.markMoonRider2=false;
        this.markWall=false;
    }
    public void take(boolean markMoonRider1){
        this.markMoonRider1=markMoonRider1;
        this.markMoonRider2=!markMoonRider1;
    }
    public boolean hasMarkMoonRider1(){
        return this.markMoonRider1;
    }
    public boolean hasMarkMoonRider2(){
        return this.markMoonRider2;
    }
    public boolean hasMarkWall(){
        return this.markWall;
    }
}
