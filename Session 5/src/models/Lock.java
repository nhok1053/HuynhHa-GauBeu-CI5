package models;

/**
 * Created by Ha San~ on 8/14/2016.
 */

public class Lock extends GameObject {
    public final static int WIDTH =32;
    public final static int HEIGHT =32;

    public Lock(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public Lock(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
