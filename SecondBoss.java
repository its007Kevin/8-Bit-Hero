import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class SecondBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondBoss extends Actor
{
    boolean isDead = false;
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer bulletTimer = new SimpleTimer();
    /**
     * Act - do whatever the SecondBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if (getX() > 690){
            move(-1);
        }
        bulletHit();
        hoverAnimation();
        if(bulletTimer.millisElapsed() > 700){
            fireRocket();
            fireRocket();
            fireRocket();
            fireRocket();
            bulletTimer.mark();
        }
    }

    public void hoverAnimation(){
        if(animationTimer.millisElapsed() > 100){
            setImage("Boss2Stance1.png");
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("Boss2Stance3.png");
        }
        if(animationTimer.millisElapsed() > 300){
            setImage("Boss2Stance2.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("Boss2Stance3.png");
        }
        if(animationTimer.millisElapsed() > 500){
            animationTimer.mark();
        }
    }

    public void fireRocket(){
        BossRocket1 rocket1 = new BossRocket1();
        BossRocket2 rocket2 = new BossRocket2();
        BossRocket3 rocket3 = new BossRocket3();
        BossRocket4 rocket4 = new BossRocket4();
        Random r = new Random();
        Random y = new Random();
        if(r.nextInt(5) == 1){
            getWorld().addObject(rocket1, getX() - 100, getY() + y.nextInt(100) - 100);
        }
        if(r.nextInt(5) == 2){
            getWorld().addObject(rocket2, getX() - 100, getY() + y.nextInt(100) - 100);
        }
        if(r.nextInt(5) == 3){
            getWorld().addObject(rocket3, getX() - 100, getY() + y.nextInt(100) - 100);
        }
        if(r.nextInt(5) == 4){
            getWorld().addObject(rocket4, getX() - 100, getY() + y.nextInt(100) - 100);
        }
    }

    public void bulletHit(){
        Boss2 world = (Boss2) getWorld();
        boolean getHit = false;
        if(isTouching(Bullet.class)){
            World myWorld = getWorld();
            Boss2 boss = (Boss2)myWorld;
            HealthBar healthBar = boss.getHealthBar();
            if(getHit == false){
                healthBar.loseHealth();
                getHit = true;
                if(healthBar.health <= 0){
                    isDead = true;
                }
                removeTouching(Bullet.class);
            }
        } else {
            getHit = false;
        }
    }
}
