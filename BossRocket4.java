import greenfoot.*;

/**
 * Write a description of class BossRocket4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossRocket4 extends BossRockets
{
    /**
     * Act - do whatever the BossRocket4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(3);
        Boss2 world = (Boss2) getWorld(); 
        turnTowards(world.ironman.getX(), world.ironman.getY());
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
}
