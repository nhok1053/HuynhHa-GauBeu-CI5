import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ha San~ on 7/24/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    Image plane1;
    Image plane2;
    int planeX=250;
    int planeY=600;
    int planeX2=200;
    int planeY2=600;

    BufferedImage bufferedImage;
    Graphics bufferedImageGraphics;
    Thread thread;

    public GameWindow (){
        this.setSize(600,800);
        this.setVisible(true);
        this.setLocation(0,0);
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
                    planeX2= e.getX();
                    planeY2 =e.getY();
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        planeY-=10;
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY+=10;
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX-=10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX+=10;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        try {
            background= ImageIO.read(new File("resources/background.png"));
            plane1 = ImageIO.read(new File("resources/plane2.png"));
            plane2 = ImageIO.read(new File("resources/plane3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.bufferedImage= new BufferedImage(600,800,BufferedImage.TYPE_3BYTE_BGR);
        this.bufferedImageGraphics = bufferedImage.getGraphics();
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        bufferedImageGraphics.drawImage(background,0,0,null);
        bufferedImageGraphics.drawImage(plane1,planeX,planeY,null);
        bufferedImageGraphics.drawImage(plane2,planeX2,planeY2,null);
        g.drawImage(bufferedImage,0,0,null);
        System.out.println("paint");
    }

    @Override
    public void run() {
        while (true){
        try {
            thread.sleep(27);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
