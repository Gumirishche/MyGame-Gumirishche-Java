package sample.events;

import sample.controllers.Controller;

public class Walls {
    public static int[][] walls = new int[14][2];
    public static boolean canGo = true;

    public int[][] wallsPosition() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 2; j++) {
                walls[i][j] = (int) (Math.random() * 8);
            }
        }
        return walls;
    }

    public boolean canGo(int y, int x) {
        for (int i = 0; i < 14; i++) {
            if (x == walls[i][0] && y == walls[i][1]) {
                System.out.println(i + "nine");
                canGo = true;
                break;
            } else {
                canGo = false;
            }
        }
        return canGo;
    }

    public boolean canShoot(int y, int x) {
        for (int i = 0; i < 14; i++) {
            if (x == walls[i][0] && y == walls[i][1]) {
                System.out.println(i + "nine");
                walls[i][0] = 8;
                walls[i][1] = 8;
                canGo = true;
                break;
            } else {
                canGo = false;
            }
        }
        return canGo;
    }
}
