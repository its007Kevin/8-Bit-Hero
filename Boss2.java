import greenfoot.*;

/**
 * Write a description of class Boss2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends GameWorld2
{
    SimpleTimer timer = new SimpleTimer();
    IronMan ironman = new IronMan();
    HealthBar healthBar = new HealthBar();
    SecondBoss boss = new SecondBoss();
    Counter counter = new Counter(); 

    GreenfootSound music = new GreenfootSound("Boss2Theme.mp3");
    GreenfootSound intro = new GreenfootSound("BossEnter.wav");
    public Boss2()
    {    
        super();
        addObject(ironman, 80, 200);
        addObject(healthBar, 400,20);
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
        if(timer.millisElapsed() > 4000){
            addObject(boss, 900, 220);
        }
        if(boss.isDead == true){
            music.stop();
            FinalBossDefeated finalBossDefeated = new FinalBossDefeated();
            finalBossDefeated.counter = counter;
            Greenfoot.setWorld(finalBossDefeated);
        }
        if(ironman.isDead == true){
            music.stop();
            LosingScreen2 lose = new LosingScreen2();
            lose.counter = counter;
            Greenfoot.setWorld(lose);
        }
    }
}

