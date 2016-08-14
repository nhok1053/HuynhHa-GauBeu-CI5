package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class BombController extends SingleController implements Colliable {
    public final static int SPEED = 3;
    protected int radius;

    public BombController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
        this.radius = 300;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            EnemyControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
            EnemyBulletControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
        }
    }
}
