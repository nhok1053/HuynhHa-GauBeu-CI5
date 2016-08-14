package controllers.Enemy;

/**
 * Created by Ha San~ on 8/14/2016.
 */
public class FlyStraight implements FlyBehavior {
    public FlyStraight() {

    }

    @Override
    public void fly(EnemyController enemyController) {
            enemyController.getGameVector().dy =enemyController.SPEED;
    }

}
