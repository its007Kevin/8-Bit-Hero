import greenfoot.*;

/**
 * Write a description of class BossFight2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossFight2 extends GameWorld2
{
    SimpleTimer timer = new SimpleTimer();
    Counter counter = new Counter();
    BossFightText text = new BossFightText();
    GreenfootSound sound = new GreenfootSound("Stage1Sound.wav");
    /**
     * Constructor for objects of class BossFight.
     * 
     */
    public BossFight2()
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
            Boss2 boss2 = new Boss2();
            boss2.counter = counter;
            Greenfoot.setWorld(boss2);
        }
    }
}

