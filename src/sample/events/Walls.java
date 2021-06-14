package sample.events;

import sample.instruments.JsonWriter1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Walls {
    public static int[][] walls = new int[14][2];
    public static boolean canGo = true;
    String[][] wallsInfo=new String[14][2];
    String[] lineWalls = new String[14];

    public void wallsPosition() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 2; j++) {
                walls[i][j] = (int) (Math.random() * 8);
            }
            wallsInfo[i][0]=String.valueOf(walls[i][0]);
            wallsInfo[i][1]=String.valueOf(walls[i][1]);
        }
        try(FileWriter writer = new FileWriter("saves\\wallsInfo1.txt", false))
        {
            for(int i=0;i<14;i++){
                writer.write(wallsInfo[i][0]+","+wallsInfo[i][1]+" ");
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        new JsonWriter1("wallsInfo1");
    }

    public boolean canGo(int y, int x) {
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
        try (FileReader fr = new FileReader("saves\\wallsInfo1.txt")) {
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
            if (x == walls[i][0] && y == walls[i][1]) {
                System.out.println(i + "nine");
                walls[i][0] = 8;
                walls[i][1] = 8;
                canGo = true;
                break;
            } else {
                canGo = false;
            }
        }
        for (int i = 0; i < 14; i++) {
            wallsInfo[i][0] = String.valueOf(walls[i][0]);
            wallsInfo[i][1] = String.valueOf(walls[i][1]);
        }
        writeWalls(wallsInfo);
        return canGo;
    }

    public void writeWalls(String[][] wallsInfo){
        try(FileWriter writer = new FileWriter("saves\\wallsInfo1.txt", false))
        {
            for(int i=0;i<14;i++){
                writer.write(wallsInfo[i][0]+","+wallsInfo[i][1]+" ");
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        new JsonWriter1("wallsInfo1");
    }
}
