package controllers.Bomb;

import models.GameObject;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public interface BombSubcriber {
    public void onBombExplode(int x, int y);
    public GameObject getGameObject();
}
