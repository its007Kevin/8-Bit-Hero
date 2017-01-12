import greenfoot.*;

/**
 * Write a description of class BossUlt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossUlt extends Projectiles
{
    SimpleTimer animationTimer = new SimpleTimer();
    public void act() 
    {
        if(animationTimer.millisElapsed() > 500){
            setImage("Ult1.png");
        }
        if(animationTimer.millisElapsed() > 700){
            setImage("Ult2.png");
        }
        if(animationTimer.millisElapsed() > 900){
            setImage("Ult3.png");
        }
        if(animationTimer.millisElapsed() > 1100){
            setImage("Ult4.png");
        }
        if(animationTimer.millisElapsed() > 1300){
            setImage("Ult3.png");
        }
        if(animationTimer.millisElapsed() > 1500){
            setImage("Ult4.png");
        }
        if(animationTimer.millisElapsed() > 1700){
            setImage("Ult3.png");
        }
        if(animationTimer.millisElapsed() > 1900){
            getWorld().removeObject(this);
            animationTimer.mark();
            return;
        }
    }    
}
