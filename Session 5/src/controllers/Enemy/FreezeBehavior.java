package controllers.Enemy;

import javafx.scene.input.KeyCode;

/**
 * Created by Ha San~ on 8/14/2016.
 */
public class FreezeBehavior {
    private int count;
    private int frezzePeriod;

    public FreezeBehavior(int frezzePeriod) {
        this.frezzePeriod = frezzePeriod;
        this.count = 0;
    }

    public void run(EnemyController enemyController) {
        switch (enemyController.getEnemyState()) {
            case NORMAL:
                break;
            case FREZEED:
                count++;
                if(count > frezzePeriod) {
                    count = 0;
                    enemyController.setEnemyState(EnemyState.NORMAL);
                }
                break;
        }
    }
}
