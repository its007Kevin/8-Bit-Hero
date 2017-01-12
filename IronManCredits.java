import greenfoot.*;

/**
 * Write a description of class IronManCredits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronManCredits extends Actor
{
    SimpleTimer animationTimer = new SimpleTimer();
    /**
     * Act - do whatever the IronManCredits wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
    }    

    public void animate(){
        if(animationTimer.millisElapsed() > 50){
            setImage("Flying 1.png");
        }
        if(animationTimer.millisElapsed() > 100){
            setImage("Flying middle.png");
        }
        if(animationTimer.millisElapsed() > 150){
            setImage("Flying 2.png");
        }
        if(animationTimer.millisElapsed() > 200){
            setImage("Flying middle.png");
        }
        if(animationTimer.millisElapsed() > 250){
            animationTimer.mark();
        }
    }
}
