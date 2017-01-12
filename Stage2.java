import greenfoot.*;

/**
 * Write a description of class Stage2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2 extends GameWorld2
{
    SimpleTimer timer = new SimpleTimer();
    Stage2Text stage2Text = new Stage2Text();
    Counter counter; 
    GreenfootSound sound = new GreenfootSound("Stage1Sound.wav");

    public Stage2()
    {    
        super();
    }

    public void act()
    {
        super.act();
        sound.setVolume(80);
        sound.play();
        addObject(stage2Text, 410,250);
        if(timer.millisElapsed() > 3000){
            sound.stop();
            BG2 bg = new BG2();
            bg.counter = counter;
            Greenfoot.setWorld(bg);
        }
    }
}
