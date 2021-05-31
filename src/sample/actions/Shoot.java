package sample.actions;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.controllers.ClientController;
import sample.controllers.Controller;
import sample.controllers.HostOrClientController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Shoot {
    String[] rider1S=new String[2], rider2S=new String[2];
    public static Stage stage = new Stage();
    GridPane gridPane;
    boolean win;

    public void shootDirection() {
        System.out.print("Shoot");
        if (HostOrClientController.client == 1) {
            Controller.d = 1;
        } else {
            ClientController.d = 1;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/filesFXML/direction.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public boolean canShootPoints(String points) {
        return Integer.parseInt(points) == 3;
    }

    public boolean win1(int y, int x) {
        try (FileReader fr = new FileReader("saves\\moonRider2Info.txt")) {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            rider2S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            if (y == Integer.parseInt(rider2S[1]) && x==Integer.parseInt(rider2S[0])) {
                System.out.println("WIN 1 PLAYER");
                win = true;
            } else {
                win = false;
            }
        return win;
    }

    public boolean win2(int y, int x) {
        try (FileReader fr = new FileReader("saved\\moonRider1Info.txt")) {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(fr);
            rider1S = reader.readLine().split(",");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (y == Integer.parseInt(rider1S[1]) && x==Integer.parseInt(rider1S[0])) {
            System.out.println("WIN 2 PLAYER");
            win = true;
        } else {
            win = false;
        }
        return win;
    }
}