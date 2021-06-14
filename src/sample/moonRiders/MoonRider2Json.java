package sample.moonRiders;

import sample.instruments.JsonReader1;
import sample.instruments.JsonWriter2;

import java.io.*;

public class MoonRider2Json {
    String[] rider2S = new String[2];
    int[] rider2 = new int[2];

    public void setMoonRider2(int y, int x) {
        try (FileWriter writer = new FileWriter("saved\\moonRider2Info2.txt", false)) {
            writer.write(y + "," + x);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter2("moonRider2Info2");
    }

    public int[] getMoonRider2() {
        try (FileReader fr = new FileReader("saved\\moonRider2Info2.txt")) {
            BufferedReader reader = new BufferedReader(fr);
            rider2S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        rider2[0] = Integer.parseInt(rider2S[0]);
        rider2[1] = Integer.parseInt(rider2S[1]);
        return rider2;
    }

    public void defaultMoonRider2() {
        try (FileWriter writer = new FileWriter("saved\\moonRider2Info2.txt", false)) {
            writer.write(7 + "," + 0);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter2("moonRider2Info2");
    }

    public int[] getMoonRider2For1() {
        new JsonReader1("moonRider2Info2", "192.168.0.194", "1234");
        try (FileReader fr = new FileReader("saves\\moonRider2Info1.txt")) {
            BufferedReader reader = new BufferedReader(fr);
            rider2S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        rider2[0] = Integer.parseInt(rider2S[0]);
        rider2[1] = Integer.parseInt(rider2S[1]);
        return rider2;
    }
}