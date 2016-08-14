package controllers.Bomb;

import controllers.ControllerManager;
import models.Bomb;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class BombControllerManager extends ControllerManager {

    private static final int BOMB_PERIOD = 150;
    private static final int LOCK_PERIOD = 200;
    private int count;
    public static final BombControllerManager instance = new BombControllerManager();

    @Override
    public void run() {
        count++;

        Random r = new Random();
        int x = r.nextInt(600);
        int y = r.nextInt(800);

        if(count >= LOCK_PERIOD) {
            count = 0;
            LockController lockController = LockController.create(x, y);
            this.add(lockController);
        }
        else if(count == BOMB_PERIOD) {
            /*  Generate bomb */
            BombController bombController = BombController.create(x, y);
            this.add(bombController);
        }
        super.run();
    }

}
