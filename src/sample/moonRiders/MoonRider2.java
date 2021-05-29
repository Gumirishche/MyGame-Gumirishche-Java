package sample.moonRiders;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoonRider2 {
    String[] rider2S=new String[2];
    int[] rider2=new int[2];
    public void setMoonRider2(int y, int x) {
        try (FileWriter writer = new FileWriter("saved\\moonRider2Info.txt", false)) {
            writer.write(y + "," + x);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int[] getMoonRider2(){
        try (FileReader fr = new FileReader("saved\\moonRider2Info.txt")) {
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
        try (FileWriter writer = new FileWriter("saved\\moonRider2Info.txt", false)) {
            writer.write(7 + "," + 0);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int[] getMoonRider2For1(){
        try {
            URL url = new URL("http://127.0.0.1:1234/moonRider2Info.txt");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());

            File f1 = new File("saves\\moonRider2Info.txt");
            FileOutputStream fw = new FileOutputStream(f1);

            byte[] b = new byte[1024];
            int count = 0;

            while ((count=bis.read(b)) != -1)
                fw.write(b,0,count);

            fw.close();
            System.out.println("Host принял rider2!");
        } catch (IOException ex) {
        }
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
}
