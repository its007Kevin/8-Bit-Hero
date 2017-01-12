import greenfoot.*;

/**
 * Write a description of class BossFireAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFireAttack extends Projectiles
{
    SimpleTimer timer = new SimpleTimer();
    int direction1;//Generates random direction for the projectile to be fired
    public void act() 
    {
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        setRotation(direction1);
        move(4);
        if(timer.millisElapsed() > 200){
            setImage("BossFireAttack.png");
        }
        if(timer.millisElapsed() > 400){
            setImage("BossFireAttack2.png");
        }
        if(timer.millisElapsed() > 600){
            timer.mark();
        }
    }    
    
    public BossFireAttack()
    {
        direction1 = Greenfoot.getRandomNumber(230 - 130) + 130;
    }
}
