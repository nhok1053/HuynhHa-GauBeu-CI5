package models;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class BulletEnemy extends GameObject{
    public final static int WIDTH = 32;
    public final static int HEIGHT = 32;

    public BulletEnemy(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}