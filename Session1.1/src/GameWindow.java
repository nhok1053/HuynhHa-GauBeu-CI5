import models.Bullet;
import models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Ha San~ on 7/24/2016.
 */


public class GameWindow extends Frame implements Runnable {

    Image bulletImage;
    Image background;
    Image plane1Image;
    Image plane2Image;
    Image enemyImage;
    //    int planeX=250;
//    int planeY=600;
//    int planeX2=200;
//    int planeY2=600;
    Plane plane1;
    Plane plane2;
    Vector<Enemyplane> enemyPlaneVector;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    Vector<Bullet> bulletVector;
    Random rd = new Random();

    class Enemyplane extends Thread {
        public int x;
        public int y;

        public void moveTo(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    //google : java awt mouse invisible
    public GameWindow() {
        this.setSize(600, 800);
        this.setVisible(true);
        this.setLocation(0, 0);
        plane1 = new Plane(200, 600);
        plane2 = new Plane(250, 600);
        bulletVector = new Vector<>();
        enemyPlaneVector = new Vector<>();

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("close");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                plane2.x = e.getX() - 33;
//                plane2.y = e.getY() - 33;
                plane2.moveTo(e.getX() - 33, e.getY() - 33);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        plane1.y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.y += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1.x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.x += 10;
                        break;
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane2.x + 30, plane2.y - 20);
                        bulletVector.add(bullet);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Bullet bullet = new Bullet();
                    bullet.moveTo(plane2.x + 30, plane2.y - 20);
                    bulletVector.add(bullet);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane1Image = ImageIO.read(new File("resources/plane2.png"));
            plane2Image = ImageIO.read(new File("resources/plane3.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            enemyImage = ImageIO.read(new File("resources/enemy_plane_yellow_2.png"));
//            enemyPlane = ImageIO.read(new File("resources/enemy_plane_yellow_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_3BYTE_BGR);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        this.thread = new Thread(this);
        thread.start();

        Thread enemyPlane = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Enemyplane enemyplane = new Enemyplane();
                        enemyplane.moveTo(rd.nextInt(520), 0);
                        enemyPlaneVector.add(enemyplane);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        enemyPlane.start();
    }


    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(background, 0, 0, null);
//        bufferedImageGraphics.drawImage(plane1Image, plane1.x, plane1.y, null);
        bufferedImageGraphics.drawImage(plane2Image, plane2.x, plane2.y, null);

        for (Bullet bullet : bulletVector) {
            bufferedImageGraphics.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        for (Enemyplane enemyplane : enemyPlaneVector) {
            bufferedImageGraphics.drawImage(enemyImage, enemyplane.x, enemyplane.y, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);
        System.out.println("paint");

    }

    @Override
    public void run() {
        while (true) {
            try {
                thread.sleep(27);
                Iterator<Enemyplane> enemyPlaneIterator = enemyPlaneVector.iterator();
                Enemyplane enemyplane;
                while (enemyPlaneIterator.hasNext()) {
                    enemyplane = enemyPlaneIterator.next();
                    enemyplane.y += 7;
                    if (enemyplane.y > 759) {
                        enemyPlaneIterator.remove();
                        break;
                    }
                }
                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    if (bullet.y <= 0) {
                        bulletIterator.remove();
                    }

                }
                try {
                    for (Enemyplane plane : enemyPlaneVector) {
                        for (Bullet bullet : bulletVector) {
                            if (plane.y + 32 >= bullet.y && plane.y < bullet.y && plane.x < bullet.x && plane.x + 32 > bullet.x) {
                                bulletVector.remove(bullet);
                                enemyPlaneVector.remove(plane);
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
