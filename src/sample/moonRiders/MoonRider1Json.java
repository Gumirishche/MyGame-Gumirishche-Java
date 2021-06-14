package sample.moonRiders;
import sample.instruments.JsonReader2;
import sample.instruments.JsonWriter1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoonRider1Json {
    String[] rider1S=new String[2];
    int[] rider1=new int[2];
    public void setMoonRider1(int y, int x) {
        try (FileWriter writer = new FileWriter("saves\\moonRider1Info1.txt", false)) {
            writer.write(y + "," + x);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter1("moonRider1Info1");
    }
    public int[] getMoonRider1(){
        try (FileReader fr = new FileReader("saves\\moonRider1Info1.txt")) {
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
        try (FileWriter writer = new FileWriter("saves\\moonRider1Info1.txt", false)) {
            writer.write(0 + "," + 7);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter1("moonRider1Info1");
    }
    public int[] getMoonRider1For2(){
        new JsonReader2("moonRider1Info1","192.168.0.194","4321");
        try (FileReader fr = new FileReader("saved\\moonRider1Info2.txt")) {
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
}