package controllers;

import models.Bullet;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Ha San~ on 8/3/2016.
 */
public class PlaneController extends SingleController implements KeyListener,Colliable  {
    public static final int SPEED = 10;

    private PlaneController(Plane plane, GameDrawer gameDrawer) {
        super(plane, gameDrawer);
        this.bulletManager = new ControllerManager();
        CollsionPool.instance.add(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    private ControllerManager bulletManager;

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameVector.dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                this.gameVector.dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameVector.dx = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.middleX() - Bullet.width / 2, this.gameObject.getY()),
                        new ImageDrawer("resources/bullet.png")
                );
                bulletManager.add(bulletController);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                this.gameVector.dy = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                this.gameVector.dx = 0;
                break;
        }
    }

    private static PlaneController planeController1;

    public static PlaneController getPlaneController1() {
        if (planeController1 == null) {
            planeController1 = new PlaneController(new Plane(250, 600), new ImageDrawer("resources/plane3.png"));
        }
        return planeController1;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
