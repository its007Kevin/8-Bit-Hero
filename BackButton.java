import greenfoot.*;

/**
 * Write a description of class BackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackButton extends Text
{
    GreenfootSound select = new GreenfootSound("Select.wav");
    int timer = 0;
    boolean mouseOver = true;
    /**
     * Act - do whatever the BackButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) == true){
            IntroWorld iW = (IntroWorld) getWorld();
            select.play();
            iW.prepare();
            iW.remove();
        }
        if (!mouseOver && Greenfoot.mouseMoved(this)){
            setImage("BackButton2.png");
            mouseOver = true;
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && ! Greenfoot.mouseMoved(this)){
            setImage("BackButton.png");
            mouseOver = false;
        }
    }    
}
