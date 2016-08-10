package controllers;

import models.Bomb;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class BombControllerManager extends ControllerManager {
    private Random random = new Random();
    private static int count = 0;

    private BombControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX = random.nextInt(500);

        if (count == 500) {
            count = 0;
            BombController bombController = new BombController(
                    new Bomb(enX, 0), new ImageDrawer("resources/bomb.png")
            );
            this.add(bombController);
        }
    }

    public final static BombControllerManager instance = new BombControllerManager();

}
