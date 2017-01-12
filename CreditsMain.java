import greenfoot.*;

/**
 * Write a description of class CreditsMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsMain extends CreditsText
{
    SimpleTimer timer = new SimpleTimer();
    /**
     * Act - do whatever the CreditsMain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer.millisElapsed() > 50){
            setLocation(getX() , getY() - 1);
            timer.mark();
        }
    }    
}
