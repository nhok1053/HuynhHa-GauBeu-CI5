package controllers;

import models.BulletEnemy;
import models.EnemyPlane;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class EnemyManager extends ControllerManager {
    private Random rd = new Random();

    private EnemyManager() {
        super();

    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(30);
            int enX = rd.nextInt(600);
            int enY = rd.nextInt(200);

            EnemyController enemyController = new EnemyController(
                    new EnemyPlane(enX, enY),
                    new ImageDrawer("resources/plane1.png")
            );
            BulletEnemyController bulletEnemyController = new BulletEnemyController(
                    new BulletEnemy(enX, enY),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            this.add(enemyController);
            this.add(bulletEnemyController);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public final static EnemyManager instance = new EnemyManager();
}
