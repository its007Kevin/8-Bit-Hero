import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Helicopter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Enemies
{
    int hp = 5;
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootSound death = new GreenfootSound("SpaceShipDeath.wav");
    GreenfootSound bomb = new GreenfootSound("Bomb.wav");
    public void act() 
    {
        animate();
        move(-3);
        Random r = new Random();
        if(r.nextInt(50) < 2){
            bomb.setVolume(80);
            bomb.play();
            spawnBomb();
        }
        if(isAtEdge() == true){
            World myWorld = getWorld();
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Bullet.class)){
            hp--;
            EnemyExplosion explode = new EnemyExplosion();
            getWorld().addObject(explode, getX() - 20, getY());
            removeTouching(Bullet.class);
        }
        if(hp <= 0){
            World myWorld = getWorld();
            BG2 bg2 = (BG2)myWorld;
            Counter counter = bg2.getCounter();
            counter.addScore();
            counter.addScore();
            counter.addScore();
            counter.addScore();
            death.play();
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX() - 20, getY());
            getWorld().removeObject(this);
        }
    }   

    /**
     * Spaceship animation
     */
    public void animate(){
        if(animationTimer.millisElapsed() > 200){
            setImage("EnemyShip1.png");
        }
        if(animationTimer.millisElapsed() > 400){
            setImage("EnemyShip2.png");
        }
        if(animationTimer.millisElapsed() > 600){
            setImage("EnemyShip3.png");
        }
        if(animationTimer.millisElapsed() > 800){
            animationTimer.mark();
        }
    }

    public void spawnBomb(){
        Bomb bomb = new Bomb();
        getWorld().addObject(bomb, getX() - 10,getY() + 30); 
    }
}
