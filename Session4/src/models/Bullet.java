package models;

/**
 * Created by Ha San~ on 8/2/2016.
 */
public class Bullet extends GameObject {
    public static final int width = 13;
    private static final int height = 30;

    public Bullet(int x, int y) {
        super(x, y, width, height);
    }
}
