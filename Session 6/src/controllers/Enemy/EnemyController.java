package controllers.Enemy;

import controllers.Bomb.BombSubcriber;
import controllers.Bomb.FreezzeSubcriber;
import controllers.Bomb.NotificationCenter;

import controllers.Colliable;
import controllers.CollsionPool;
import controllers.SingleController;
import models.Enemy;
import views.GameDrawer;
import views.ImageDrawer;


public class EnemyController extends
        SingleController implements
        Colliable, BombSubcriber, FreezzeSubcriber {

    public static final int SPEED =2;
    private EnemyState enemyState;
    private int frezzeCount;

    private int FREZZE_PERIOD = 200;

    private FreezeBehavior freezeBehavior;
    private ShotBehavior shotBehavior;
    private FlyBehavior flyBehavior;
    public EnemyController(Enemy gameObject, GameDrawer gameDrawer,FreezeBehavior freezeBehavior,FlyBehavior flyBehavior,ShotBehavior shotBehavior) {
        super(gameObject, gameDrawer);

        //this.gameVector.dy = SPEED;
        CollsionPool.instance.add(this);
        NotificationCenter.instance
                .subsribe(this);
        NotificationCenter.instance
                .subsribeFrezze(this);
        enemyState = EnemyState.NORMAL;
        this.freezeBehavior = freezeBehavior;
        this.flyBehavior = flyBehavior;
        this.shotBehavior = shotBehavior;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }

    public void setEnemyState(EnemyState enemyState) {
        this.enemyState = enemyState;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    public static EnemyController create(int x, int y, EnemyPlaneType type) {
        EnemyController enemyController = null;

        switch (type) {
            case YELLOW:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_yellow_1.png"),
                        new FreezeBehavior(200),
                        new FlyStraight(),
                        null);

                break;
            case WHITE:
                enemyController = new EnemyController(
                        new Enemy(x, y),
                        new ImageDrawer("resources/enemy_plane_white_1.png"),
                        new FreezeBehavior(300),
                        new FlyZiczac(),
                        new FollowShotBehavior());
                break;
        }
        return enemyController;
    }

    @Override
    public void onBombExplode(int x, int y) {
        gameObject.destroy();
    }

    @Override
    public void run() {

        switch (this.enemyState) {
            case NORMAL:
                super.run();
                break;
            case FREZEED:
                break;
        }

        if (freezeBehavior != null)
            freezeBehavior.run(this);
        if(flyBehavior != null){
            flyBehavior.fly(this);
        }
        if(shotBehavior != null)
            shotBehavior.doShot(this);
    }

    @Override
    public void onFrezze(int x, int y) {
        enemyState = EnemyState.FREZEED;
        frezzeCount = 0;
    }
}