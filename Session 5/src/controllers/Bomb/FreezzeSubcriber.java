package controllers.Bomb;

import models.GameObject;

/**
 * Created by Ha San~ on 8/14/2016.
 */
public interface FreezzeSubcriber {
     void onFrezze(int x, int y);
    GameObject getGameObject();
}
