package sample.instruments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter2 {
    private  String number = "";

    public JsonWriter2(String file){

        try(FileReader fr = new FileReader("saved\\" + file + ".txt"))
        {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            number = line;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try(
                FileWriter writer = new FileWriter("saved\\" + file + ".json", false))
        {
            // запись всей строки
            final char dm = (char) 34;
            writer.write("{\n");
            writer.write(dm + "playerTwo" + dm + " : " + number + "\n");
            writer.write("}");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        final char dm = (char) 34;
        new JsonWriter2("Yuh");
    }
}