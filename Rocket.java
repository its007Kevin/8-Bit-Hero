import greenfoot.*;

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Projectiles
{
    SimpleTimer animationTimer = new SimpleTimer();
    public void act() 
    {
        setRotation(180);
        move(4);
        animate();
        if(isAtEdge() == true){
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Bullet.class)){
            World myWorld = getWorld();
            BG bg = (BG)myWorld;
            Counter counter = bg.getCounter();
            counter.addScore();
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY());
            removeTouching(Bullet.class);
            getWorld().addObject(explosion, getX(),getY());
            getWorld().removeObject(this);
        }
    }    

    public void animate(){
        if(animationTimer.millisElapsed() > 200){
            setImage("Rocket Better One.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("Rocket Better One2.png");
        }
        if(animationTimer.millisElapsed() > 600){
            setImage("Rocket Better One3.png");
        }
        if(animationTimer.millisElapsed() > 800){
            setImage("Rocket Better One2.png");
        }
        if(animationTimer.millisElapsed() > 1000){
            animationTimer.mark();
        }
    }
}
