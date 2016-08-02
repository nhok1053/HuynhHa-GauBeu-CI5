package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable{
    public static final int SPEED = 7;
    public BulletEnemyController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = 10;
        CollsionPool.instance.add(this);
    }



    @Override
    public void run() {
        super.run();
        if(gameObject.getY()>800){
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController){
            this.gameObject.destroy();
        }
    }

}
