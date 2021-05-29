package sample.moonRiders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoonRider1 {
    String[] rider1S=new String[2];
    int[] rider1=new int[2];
    public void setMoonRider1(int y, int x) {
        try (FileWriter writer = new FileWriter("saves\\moonRider1Info.txt", false)) {
            writer.write(y + "," + x);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int[] getMoonRider1(){
        try (FileReader fr = new FileReader("saves\\moonRider1Info.txt")) {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            rider1S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        rider1[0]=Integer.parseInt(rider1S[0]);
        rider1[1]=Integer.parseInt(rider1S[1]);
        return rider1;
    }

    public void defaultMoonRider1(){
        try (FileWriter writer = new FileWriter("saves\\moonRider1Info.txt", false)) {
            writer.write(0 + "," + 7);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
