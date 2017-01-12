import greenfoot.*;

/**
 * Write a description of class YouWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWin extends GameWorld2
{
    YouWinText youWin = new YouWinText();
    EndGameScore endGameScore = new EndGameScore();
    Counter counter = new Counter();
    SimpleTimer timer = new SimpleTimer();
    GreenfootSound music = new GreenfootSound("Win.mp3");
    /**
     * Constructor for objects of class YouWin.
     */
    public YouWin()
    {
        super();
        addObject(youWin, 400,200);
        addObject(endGameScore, 630, 330);
    }

    public Counter getCounter(){
        return counter;
    }

    public void act(){
        super.act();
        music.play();
        addObject(counter, 470,153);
        if(timer.millisElapsed() > 10000){
            music.stop();
            Greenfoot.setWorld(new Credits());
        }
    }
}
