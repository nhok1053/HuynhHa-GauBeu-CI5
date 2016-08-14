package models;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class Bomb extends GameObject {
    public final static int width = 60;
    public final static int height = 60;

    public Bomb(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Bomb(int x, int y) {
        super(x, y, width, height);
    }
}
