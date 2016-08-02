package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class BulletController extends SingleController implements Colliable{
    private static final int SPEED = 20;

    public BulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            colliable.getGameObject().destroy();
            this.getGameObject().destroy();
        }
    }
}
