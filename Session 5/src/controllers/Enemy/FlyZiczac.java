package controllers.Enemy;

/**
 * Created by Ha San~ on 8/14/2016.
 */
public class FlyZiczac implements FlyBehavior {
    private int count;
    public FlyZiczac(){
    }

    @Override
    public void fly(EnemyController enemyController) {
        count++;
        if(count == 1 ) {
            enemyController.getGameVector().dx = enemyController.SPEED;
            enemyController.getGameVector().dy = enemyController.SPEED;

        }
        if (enemyController.getGameObject().getX() >=600 || enemyController.getGameObject().getX() <= 0){
            enemyController.getGameVector().dx = -enemyController.getGameVector().dx;
        }
    }
}
