package controllers.gamescenes;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Ha San~ on 8/17/2016.
 */
public interface GameScene extends Runnable {
    void draw(Graphics g);
    KeyListener getKeyListener();
    void setGameSceneListener(GameSceneListener gameSceneListener);
}