package controllers;

import models.GameObject;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
