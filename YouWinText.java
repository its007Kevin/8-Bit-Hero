import greenfoot.*;

/**
 * Write a description of class YouWinText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouWinText extends Text
{
    SimpleTimer timer = new SimpleTimer();
    /**
     * Act - do whatever the Stage2Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer.millisElapsed() > 500){
            setImage("YouWin.png");
        }
        if(timer.millisElapsed() > 1000){
            setImage("Blank.png");
        }
        if(timer.millisElapsed() > 1500){
            timer.mark();
        }
    }
}
