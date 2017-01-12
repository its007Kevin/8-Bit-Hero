import greenfoot.*;

/**
 * Write a description of class BossRockets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossRockets extends Actor
{
    int direction; //Generates a random direction for the rocket to be fired
    /**
     * Act - do whatever the BossRockets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(4);
        setRotation(direction);
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Bullet.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY());
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
        }
    }    

    public BossRockets(){
        direction = Greenfoot.getRandomNumber(230 - 145) + 145;
    }
}
