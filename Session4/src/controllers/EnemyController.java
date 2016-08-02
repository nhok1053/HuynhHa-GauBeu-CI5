package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class EnemyController extends SingleController implements Colliable{
    public static final int SPEED =3;
    public EnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dx =SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
