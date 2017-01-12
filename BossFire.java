import greenfoot.*;

/**
 * Write a description of class BossFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFire extends Projectiles
{
    SimpleTimer animationTimer = new SimpleTimer();
    int direction; //Randomly generates a direction for the projectile
    public void act() 
    {
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        setRotation(direction);
        move(4);
        if(animationTimer.millisElapsed() > 200){
            setImage("BossFire1.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("BossFire2.png");
        }
        if(animationTimer.millisElapsed() > 600){
            animationTimer.mark();
        }
    }    

    public BossFire(){
        direction = Greenfoot.getRandomNumber(230 - 130) + 130;
    }
}
