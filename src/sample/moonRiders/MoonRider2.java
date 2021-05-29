package sample.moonRiders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoonRider2 {
    String[] rider2S=new String[2];
    int[] rider2=new int[2];
    public void setMoonRider2(int y, int x) {
        try (FileWriter writer = new FileWriter("saves\\moonRider2Info.txt", false)) {
            writer.write(y + "," + x);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int[] getMoonRider2(){
        try (FileReader fr = new FileReader("saves\\moonRider2Info.txt")) {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            rider2S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        rider2[0]=Integer.parseInt(rider2S[0]);
        rider2[1]=Integer.parseInt(rider2S[1]);
        return rider2;
    }

    public void defaultMoonRider2(){
        try (FileWriter writer = new FileWriter("saves\\moonRider2Info.txt", false)) {
            writer.write(7 + "," + 0);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
