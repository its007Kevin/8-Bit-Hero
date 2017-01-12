import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Projectiles
{
    public void act() 
    {
        move(6);
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(SecondBoss.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
        }
    }
}
