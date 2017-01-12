import greenfoot.*;

/**
 * Write a description of class GroundExplosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GroundExplosion extends Actor
{
    SimpleTimer timer = new SimpleTimer();
    public void act() 
    {
        if(timer.millisElapsed() > 200){
            setImage("GroundExplosion1.png");
        }
        if(timer.millisElapsed() > 400){
            setImage("GroundExplosion2.png");
        }
        if(timer.millisElapsed() > 600){
            setImage("GroundExplosion3.png");
        }
        if(timer.millisElapsed() > 800){
            setImage("GroundExplosion4.png");
        }
        if(timer.millisElapsed() > 1000){
            setImage("GroundExplosion5.png");
        }
        if(timer.millisElapsed() > 1200){
            setImage("GroundExplosion6.png");
        }
        if(timer.millisElapsed() > 1400){
            getWorld().removeObject(this);
        }
    }    
}
