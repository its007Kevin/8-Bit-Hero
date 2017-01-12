import greenfoot.*;

/**
 * Write a description of class ControlsText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlsText extends Text
{
    GreenfootSound select = new GreenfootSound("Select.wav");
    int timer = 0;
    boolean mouseOver = true;
    /**
     * Act - do whatever the ControlsText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) == true){
            IntroWorld wI = (IntroWorld) getWorld();
            select.play();
            wI.prepare2();
            wI.remove2();
        }
        if (!mouseOver && Greenfoot.mouseMoved(this)){
            setImage("ControlsText2.png");
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this)){
            setImage("ControlsText.png");
            mouseOver = false;
        }
    }
}
