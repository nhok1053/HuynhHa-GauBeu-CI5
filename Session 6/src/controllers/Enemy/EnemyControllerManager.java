package controllers.Enemy;

import controllers.ControllerManager;

/**
 * Created by Ha San~ on 8/10/2016.
 */
public class EnemyControllerManager extends ControllerManager {

    private int count;
    private static final int RESPAWN_TYPE1 = 100;
    private static final int RESPAWN_TYPE2 = 200;

    private EnemyControllerManager() {
        super();
    }
    @Override
    public void run() {
        super.run();
        count++;
        int enX = 10;
        int enY = 10;
        if(count == RESPAWN_TYPE2) {
            count = 0;
            /* TODO: Generate plane controller 2 */
            for (int i = 0; i < 5; i++) {
            EnemyController enemyController = EnemyController.create(enX,enY, EnemyPlaneType.WHITE);

            this.add(enemyController);
                enX += 100;
            }
        }
        else if (count == RESPAWN_TYPE1) {
            for (int i = 0; i < 5; i++) {
                EnemyController enemyController = EnemyController.create(enX,enY,EnemyPlaneType.YELLOW);
                this.add(enemyController);
                enX += 100;

            }
        }
    }
    public final static EnemyControllerManager instance = new EnemyControllerManager();
}
