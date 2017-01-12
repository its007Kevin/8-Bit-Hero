import greenfoot.*;

/**
 * Write a description of class EnemyExploison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyExplosion extends Explosions
{
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootSound death = new GreenfootSound("EnemyDeath.wav");
    public void act() 
    {
        if(animationTimer.millisElapsed() > 100){
            setImage("EnemyExplosion1.png");
            death.setVolume(70);
            death.play();
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("EnemyExplosion2.png");
        }
        if(animationTimer.millisElapsed() > 300){
            setImage("EnemyExplosion3.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("EnemyExplosion4.png");
        }
        if(animationTimer.millisElapsed() > 500){
            getWorld().removeObject(this);
        }
    }    
}
