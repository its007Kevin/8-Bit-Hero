import greenfoot.*;

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1 extends GameWorld
{
    SimpleTimer timer = new SimpleTimer();
    Stage1Text stage1Text = new Stage1Text();
    GreenfootSound sound = new GreenfootSound("Stage1Sound.wav");
    public Stage1()
    {    
        super();
    }

    public void act()
    {
        sound.setVolume(80);
        sound.play();
        super.act();
        addObject(stage1Text, 410,230);
        if(timer.millisElapsed() > 3000){
            sound.stop();
            Greenfoot.setWorld(new BG());
        }
    }
}

