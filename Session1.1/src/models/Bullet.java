package models;

/**
 * Created by Ha San~ on 7/27/2016.
 */
public class Bullet {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Bullet() {
    }
}
