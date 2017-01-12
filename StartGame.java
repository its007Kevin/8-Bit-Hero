import greenfoot.*;

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends Text
{
    boolean mouseOver = true;
    public boolean startGame = false;
    /**
     * Act - do whatever the StartGame wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!mouseOver && Greenfoot.mouseMoved(this)){
            setImage("StartGame2.png");
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this)){
            setImage("StartGame.png");
            mouseOver = false;
        }
        if(Greenfoot.mouseClicked(this)){
            startGame = true;
        }
    }    
}
