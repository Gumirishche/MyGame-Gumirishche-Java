package sample.instruments;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReader1 {
    public String memory;
    public String fileN = "";

    public JsonReader1(String file, String ip, String port) {
        char[] file2 = file.toCharArray();
        file2[file2.length - 1] = '1';
        for (int i = 0; i < file2.length; i++) {
            fileN = fileN + file2[i];
        }
        try {
            URL url = new URL("http://" + ip + ":" + port + "/" + file + ".json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            File f1 = new File("saves\\" + fileN + ".json");
            FileOutputStream fw = new FileOutputStream(f1);

            byte[] b = new byte[1024];
            int count = 0;

            while ((count = bis.read(b)) != -1)
                fw.write(b, 0, count);

            fw.close();
        } catch (IOException ex) {
        }


        try (FileReader fr = new FileReader("saves\\" + fileN + ".json")) {
            BufferedReader reader = new BufferedReader(fr);
            String line = "", line2 = "";
            line = reader.readLine();
            line = "";
            line = reader.readLine();
            char[] result = line.toCharArray();
            System.out.println(result.length);
            for (int i = 14; i < result.length; i++) {
                line2 = line2 + result[i];
                System.out.println("line:" + line2);
            }
            memory = line2;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        System.out.println("memory:" + memory);

        try (FileWriter writer = new FileWriter("saves\\" + fileN + ".txt", false)) {
            writer.write(memory);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void main(String[] args) {
        new JsonReader2("Yuh", "192.168.0.194", "1234");
    }
}