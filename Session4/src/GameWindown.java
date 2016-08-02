import controllers.CollsionPool;
import controllers.EnemyManager;
import controllers.PlaneController;
import utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Ha San~ on 8/2/2016.
 */
public class GameWindown extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;
    Thread t;
    PlaneController planeController1;
    public GameWindown(){
        System.out.println("Game windown open");
        this.setVisible(true);
        this.setSize(600,800);
        this.setLocation(0,0);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Exit programe");
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
//        background = ImageIO.read(new File("resources/background.png"));
        this.bufferedImage = new BufferedImage(600,800,BufferedImage.TYPE_INT_ARGB);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();
        background = Utils.loadImage("resources/background.png");
        planeController1 = PlaneController.getPlaneController1();

        this.addKeyListener(planeController1);
      Thread enemyPlane = new Thread(){
          @Override
          public void run() {
              while(true){
                  try {
                      Thread.sleep(100);
                      EnemyManager.instance.run();
                      CollsionPool.instance.run();
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
        planeController1.draw(bufferedImageGraphics);
        EnemyManager.instance.draw(bufferedImageGraphics);
        g.drawImage(bufferedImage,0,0,null);
        System.out.println("paint");
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
                PlaneController.getPlaneController1().run();
                CollsionPool.instance.run();

                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
