import greenfoot.*;

/**
 * Write a description of class EnemyExplosion2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2Explosion extends Explosions
{
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootSound death = new GreenfootSound("EnemyDeath.wav");
    public void act() 
    {
        if(animationTimer.millisElapsed() > 100){
            setImage("Enemy2Explosion1.png");
            death.setVolume(70);
            death.play();
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("Enemy2Explosion2.png");
        }
        if(animationTimer.millisElapsed() > 300){
            setImage("Enemy2Explosion3.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("Enemy2Explosion4.png");
        }
        if(animationTimer.millisElapsed() > 500){
            getWorld().removeObject(this);
        }
    }    
}
