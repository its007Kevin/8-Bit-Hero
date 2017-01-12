import greenfoot.*;

/**
 * Write a description of class BossFight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFight extends GameWorld
{
    SimpleTimer timer = new SimpleTimer();
    Counter counter = new Counter();
    BossFightText text = new BossFightText();
    GreenfootSound sound = new GreenfootSound("Stage1Sound.wav");
    /**
     * Constructor for objects of class BossFight.
     * 
     */
    public BossFight()
    {
        super();
    }

    public Counter getCounter(){
        return counter;
    }

    public void act()
    {
        super.act();
        sound.setVolume(80);
        sound.play();
        addObject(text, 410, 230);
        if(timer.millisElapsed() > 3000){
            Boss1 boss = new Boss1();
            boss.counter = counter;
            Greenfoot.setWorld(boss);
        }
    }
}
