import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Explosions
{
    GreenfootSound explode = new GreenfootSound("Explosion.wav");
    SimpleTimer animationTimer = new SimpleTimer();
    public void act() 
    {
        if(animationTimer.millisElapsed() > 100){
            setImage("Explosion1.png");
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("Explosion2.png");
        }
        if(animationTimer.millisElapsed() > 300){
            setImage("Explosion3.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("Explosion4.png");
        }
        if(animationTimer.millisElapsed() > 500){
            setImage("Explosion5.png");
        }
        if(animationTimer.millisElapsed() > 600){
            setImage("Explosion6.png");
        }
        if(animationTimer.millisElapsed() > 700){
            setImage("Explosion7.png");
        }
        if(animationTimer.millisElapsed() > 800){
            setImage("Explosion9.png");
        }
        if(animationTimer.millisElapsed() > 900){
            setImage("Explosion10.png");
        }
        if(animationTimer.millisElapsed() > 1000){
            setImage("Explosion11.png");
        }
        if(animationTimer.millisElapsed() > 1100){
            setImage("Explosion12.png");
        }
        if(animationTimer.millisElapsed() > 1200){
            getWorld().removeObject(this);
        }
    }    
    
    public Explosion(){
        explode.setVolume(80);
        explode.play();
    }
}
