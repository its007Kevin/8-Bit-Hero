import greenfoot.*;

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Projectiles
{
    public void act() 
    {
        if(isTouching(Bullet.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY()); 
            removeTouching(Bullet.class);
            World myWorld = getWorld();
            BG2 bg2 = (BG2)myWorld;
            Counter counter = bg2.getCounter();
            counter.addScore();
            getWorld().removeObject(this);
            return;
        }
        setLocation(getX(), getY() + 2);
        setRotation(30);
        if(isAtEdge() == true){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY() - 3); 
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(IronMan.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY() - 3); 
        }
        if(isTouching(Enemy2.class)){
            Explosion explode = new Explosion();
            getWorld().addObject(explode, getX(), getY());
            removeTouching(Enemy2.class);
            getWorld().removeObject(this);
            return;
        }
    }    
}
