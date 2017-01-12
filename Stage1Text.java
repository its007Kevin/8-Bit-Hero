import greenfoot.*;

/**
 * Write a description of class Stage1Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1Text extends Text
{
    int timer = 0;
    /**
     * Act - do whatever the Stage1Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        timer++;
        if(timer == 7){
            setImage("Stage1Loading.png");
        }
        if(timer == 14){
            setImage("Blank.png");
        }
        if(timer == 21){
            timer = 0;
        }
    }    
}
