package models;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int SIZE = 32;

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public EnemyBullet(int x, int y) {
        super(x, y, SIZE, SIZE);
    }
}
