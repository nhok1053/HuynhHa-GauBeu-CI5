package models;

/**
 * Created by Ha San~ on 8/2/2016.
 */
public class EnemyPlane extends GameObject{
    public static final int width = 45;
    public static final int height = 30;
    public EnemyPlane() {
    }

    public EnemyPlane(int x, int y) {
        super(x, y, width, height);
    }

}
