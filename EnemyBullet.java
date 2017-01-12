import greenfoot.*;

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Projectiles
{
    public void act() 
    {
        move(-6);
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Bullet.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion,getX(),getY());
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
        }
    }    
}
