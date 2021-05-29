package sample.moonRiders;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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
    public int[] getMoonRider1For2(){
        try {
            URL url = new URL("http://127.0.0.1:4321/moonRider1Info.txt");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            File f1 = new File("saved\\moonRider1Info.txt");
            FileOutputStream fw = new FileOutputStream(f1);

            byte[] b = new byte[1024];
            int count = 0;

            while ((count=bis.read(b)) != -1)
                fw.write(b,0,count);

            fw.close();
            System.out.println("Client принял rider1!");
        } catch (IOException ex) {
        }
        try (FileReader fr = new FileReader("saved\\moonRider1Info.txt")) {
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
