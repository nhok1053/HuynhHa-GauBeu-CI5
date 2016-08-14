package controllers.Bomb;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.GameObject;
import models.Lock;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/14/2016.
 */
public class LockController extends SingleController implements Colliable{
    public LockController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }
public static LockController create(int x , int y){
    return new LockController(
            new Lock(x,y), new ImageDrawer("resources/lock.png")
    );
}


    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onFrezze(
                    gameObject.getX(),
                    gameObject.getY()
            );
            gameObject.destroy();
        }
    }
}
