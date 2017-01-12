import greenfoot.*;
import java.util.*;

/**
 * Write a description of class BG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BG extends GameWorld
{
    IronMan ironman = new IronMan();
    Counter counter = new Counter();
    SimpleTimer timer = new SimpleTimer();
    GreenfootSound music = new GreenfootSound("BombMan.mp3");
    GreenfootSound select = new GreenfootSound("Select.wav");

    public BG()
    {    
        super();
        addObject(ironman, 80, 200);
        addObject(counter, 50,15);
    }

    public Counter getCounter(){
        return counter;
    }

    private void spawnRocket(){
        Rocket rocket = new Rocket();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(rocket, 800, y);
    }

    private void spawnEnemy(){
        Enemy enemy = new Enemy();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(enemy, 800,y);
    }

    public void act()
    {
        super.act();
        music.playLoop();
        Random r = new Random();
        if(r.nextInt(100) < 2){
            spawnRocket();
        }
        if(r.nextInt(250) < 2){
            spawnEnemy();
        }
        if(ironman.isDead == true){
            music.stop();
            LosingScreen lose = new LosingScreen();
            lose.counter = counter;
            Greenfoot.setWorld(lose);
        }
        if(timer.millisElapsed() > 30000){
            select.setVolume(80);
            select.play();
            music.stop();
            BossFight text = new BossFight();
            text.counter = counter;
            Greenfoot.setWorld(text);
        }
    }
}

