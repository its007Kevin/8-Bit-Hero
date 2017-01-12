import greenfoot.*;

/**
 * Write a description of class LoseText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseText extends Text
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
            setImage("LoseScreen2.png");
        }
        if(timer == 60){
            setImage("LoseScreen1.png");
            timer = 0;
        }
    }    
}
