import greenfoot.*;

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends GameWorld
{
    SimpleTimer timer = new SimpleTimer();
    IronMan ironman = new IronMan();
    HealthBar healthBar = new HealthBar();
    BossGround ground = new BossGround();
    Boss boss = new Boss();
    Counter counter = new Counter(); 
    
    GreenfootSound music = new GreenfootSound("Boss1.mp3");

    public Boss1()
    {    
        super();
        addObject(ironman, 80, 200);
        addObject(healthBar, 400,20);
        addObject(ground,600,400);
    }

    public Counter getCounter(){
        return counter;
    }

    public HealthBar getHealthBar(){
        return healthBar;
    }

    public void act()
    {
        super.act();
        music.setVolume(60);
        music.playLoop();
        if(timer.millisElapsed() > 2000){
            addObject(boss, 700, -20);
        }
        if(boss.isDead == true){
            music.stop();
            Stage2 stage2 = new Stage2(); 
            stage2.counter = counter;
            Greenfoot.setWorld(stage2);
        }
        if(ironman.isDead == true){
            music.stop();
            LosingScreen lose = new LosingScreen();
            lose.counter = counter;
            Greenfoot.setWorld(lose);
        }
    }
}

