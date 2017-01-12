import greenfoot.*;

/**
 * Write a description of class Stage2Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2Text extends Text
{
    int timer = 0;
    /**
     * Act - do whatever the Stage2Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer == 7){
            setImage("Stage2.png");
        }
        if(timer == 14){
            setImage("Blank.png");
        }
        if(timer == 21){
            timer = 0;
        }
    }    
}
