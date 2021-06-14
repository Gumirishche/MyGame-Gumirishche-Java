package sample.actions;

import sample.instruments.JsonWriter1;
import sample.instruments.JsonWriter2;

import java.io.FileWriter;
import java.io.IOException;

public class QueueJson {
    private int queue;

    public void QueueJson() {
        queue = (int) (Math.random() * 2 + 1);
        try (FileWriter writer = new FileWriter("saves\\queue1.txt", false)) {
            writer.write(String.valueOf(queue));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter1("queue1");
        try (FileWriter writer = new FileWriter("saved\\queue2.txt", false)) {
            writer.write(String.valueOf(queue));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        new JsonWriter2("queue2");
    }
}