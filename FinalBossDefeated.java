import greenfoot.*;

/**
 * Write a description of class FinalBossDefeated here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBossDefeated extends GameWorld2
{
    FinalBossDefeatedText text = new FinalBossDefeatedText();
    SimpleTimer timer = new SimpleTimer();
    Counter counter = new Counter(); 
    GreenfootSound sound = new GreenfootSound("Stage1Sound.wav");
    /**
     * Constructor for objects of class FinalBossDefeated.
     * 
     */
    public FinalBossDefeated()
    {
        super();
        addObject(text, 400,200);
    }

    public Counter getCounter(){
        return counter;
    }

    public void act(){
        super.act();
        sound.setVolume(80);
        sound.play();
        if(timer.millisElapsed() > 4000){
            sound.stop();
            YouWin win = new YouWin();
            win.counter = counter;
            Greenfoot.setWorld(win);
        }
    }
}
