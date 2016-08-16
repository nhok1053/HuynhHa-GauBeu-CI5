package controllers.Bomb;

import controllers.*;
import models.Bomb;
import models.GameObject;
import utils.Utils;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class BombController extends SingleController implements Colliable {

    public BombController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
    }
    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png"));
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            NotificationCenter.instance.onBomExpode(gameObject.getX(), gameObject.getY());
//            Utils.playSound("resources/explosion.wav", false);
            gameObject.destroy();
        }
    }
}
