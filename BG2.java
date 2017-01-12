import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class BG2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BG2 extends GameWorld2
{
    IronMan ironman = new IronMan();
    Counter counter = new Counter();
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer timer2 = new SimpleTimer();//SpaceShip spawn
    GreenfootSound music = new GreenfootSound("Stage2Music.mp3");

    public BG2()
    {    
        super();
        addObject(ironman, 80, 200);
    }

    public Counter getCounter(){
        return counter;
    }

    private void spawnEnemy(){
        Enemy2 enemy = new Enemy2();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(enemy, 800,y);
    }

    private void spawnSpaceShip(){
        SpaceShip spaceShip = new SpaceShip();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(spaceShip, 800 , 40);
    }

    public void act()
    {
        super.act();
        music.play();
        addObject(counter, 50, 15);
        Random r = new Random();
        if(r.nextInt(200) < 2){
            spawnEnemy();
        }
        if(timer.millisElapsed() > 6000){
            spawnSpaceShip();
            timer.mark();
        }
        if(ironman.isDead == true){
            music.stop();
            LosingScreen2 lose = new LosingScreen2();
            lose.counter = counter;
            Greenfoot.setWorld(lose);
        }
        if(timer2.millisElapsed() > 30000){
            music.stop();
            BossFight2 text = new BossFight2();
            text.counter = counter;
            Greenfoot.setWorld(text);
        }
    }
}

