import greenfoot.*;

/**
 * Write a description of class CreditsEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditsEnd extends CreditsText
{
    int timer = 0;
    /**
     * Act - do whatever the IntroText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer == 30){
            setImage("ThankYouForPlaying.png");
        }
        if(timer == 60){
            setImage("Blank.png");
            timer = 0;
        }
    }    
}  

