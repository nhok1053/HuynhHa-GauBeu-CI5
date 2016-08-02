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

    Thread thread;

    @Override
    public void run() {
        super.run();
        int enX = rd.nextInt(600);
        int enY = rd.nextInt(200);

        EnemyController enemyController = new EnemyController(
                new EnemyPlane(enX, enY),
                new ImageDrawer("resources/enemy_plane_yellow_1.png")
        );
        BulletEnemyController bulletEnemyController = new BulletEnemyController(
                new BulletEnemy(enX, enY),
                new ImageDrawer("resources/enemy_bullet.png")
        );
        this.add(enemyController);
        this.add(bulletEnemyController);


    }


    public final static EnemyManager instance = new EnemyManager();
}
