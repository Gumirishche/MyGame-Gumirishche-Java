package sample.events;

import sample.controllers.Controller;

import java.io.FileWriter;
import java.io.IOException;

public class Walls {
    public static int[][] walls = new int[14][2];
    public static boolean canGo = true;

    public int[][] wallsPosition() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 2; j++) {
                walls[i][j] = (int) (Math.random() * 8);
            }
        }
        return walls;
    }

    public boolean canGo(int y, int x) {
        for (int i = 0; i < 14; i++) {
            if (x == walls[i][0] && y == walls[i][1]) {
                System.out.println(i + "nine");
                canGo = true;
                break;
            } else {
                canGo = false;
            }
        }
        return canGo;
    }

    public boolean canShoot(int y, int x) {
        for (int i = 0; i < 14; i++) {
            if (x == walls[i][0] && y == walls[i][1]) {
                System.out.println(i + "nine");
                walls[i][0] = 8;
                walls[i][1] = 8;
                canGo = true;
                Controller.wallsInfo[i][0]=String.valueOf(walls[i][0]);
                Controller.wallsInfo[i][1]=String.valueOf(walls[i][1]);
                break;
            } else {
                canGo = false;
            }
        }
        try(FileWriter writer = new FileWriter("saves\\wallsInfo.txt", false))
        {
            // запись всей строки
            for(int i=0;i<14;i++){
                writer.write(Controller.wallsInfo[i][0]+","+Controller.wallsInfo[i][1]+" ");
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return canGo;
    }
}
