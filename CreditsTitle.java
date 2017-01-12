import greenfoot.*;

/**
 * Write a description of class CreditsTitle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsTitle extends CreditsText
{
    SimpleTimer timer = new SimpleTimer();
    /**
     * Act - do whatever the IntroText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer.millisElapsed() > 0){
            setImage("CreditsTitle.png");
        }
        if(timer.millisElapsed() > 3300){
            setImage("Blank.png");
        }
        if(timer.millisElapsed() > 3500){
            setImage("CreditsTitle.png");
        }
        if(timer.millisElapsed() > 3700){
            setImage("Blank.png");
        }
        if(timer.millisElapsed() > 3900){
            setImage("CreditsTitle.png");
        }
    }    
}

