package sample.actions;

import java.io.FileWriter;
import java.io.IOException;

public class Queue {
    private int queue;
    public void queue(){
        queue=(int) (Math.random() * 2 + 1);
        try(FileWriter writer = new FileWriter("saves\\queue.txt", false))
        {
                writer.write(String.valueOf(queue));
                writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try(FileWriter writer = new FileWriter("saved\\queue.txt", false))
        {
                writer.write(String.valueOf(queue));
                writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
