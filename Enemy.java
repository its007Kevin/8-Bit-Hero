import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Enemies
{
    SimpleTimer bulletTimer = new SimpleTimer();
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootSound laser = new GreenfootSound("Laser.wav");
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(180);
        animate();
        BG world = (BG) getWorld(); 
        turnTowards(world.ironman.getX(), world.ironman.getY());
        move(3);
        if(bulletTimer.millisElapsed() > 2000){
            fire();
            bulletTimer.mark();
        }
        if(isTouching(Bullet.class)){
            World myWorld = getWorld();
            BG bg = (BG)myWorld;
            Counter counter = bg.getCounter();
            counter.addScore();
            counter.addScore();
            EnemyExplosion explode = new EnemyExplosion();
            getWorld().addObject(explode, getX(),getY());
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Rocket.class)){
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(),getY());
            removeTouching(Rocket.class);
            getWorld().removeObject(this);
        }
    }    

    /**
     * Creates a bullet object at that actor's location
     */
    private void fire(){
        EnemyBullet bullet = new EnemyBullet();
        laser.setVolume(80);
        laser.play();
        getWorld().addObject(bullet, getX() - 40,getY() - 3); 
    }

    public void animate(){
        if(animationTimer.millisElapsed() > 50){
            setImage("Enemy1Stance1.png");
        }
        if(animationTimer.millisElapsed() > 100){
            setImage("Enemy1Stance2.png");
        }
        if(animationTimer.millisElapsed() > 150){
            setImage("Enemy1Stance3.png");
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("Enemy1Stance2.png");
        }
        if(animationTimer.millisElapsed() > 250){
            animationTimer.mark();
        }
    }
}
