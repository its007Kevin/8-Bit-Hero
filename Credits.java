import greenfoot.*;

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends EndScreen
{
    CreditsTitle title = new CreditsTitle();
    CreditsMain main = new CreditsMain();
    CreditsEnd end = new CreditsEnd();
    ReturnText returnText = new ReturnText();
    IronManCredits ironMan = new IronManCredits();

    SimpleTimer timer = new SimpleTimer();
    SimpleTimer timer2 = new SimpleTimer();

    GreenfootSound music = new GreenfootSound("Credits.mp3");
    /**
     * Constructor for objects of class Credits.
     * 
     */
    public Credits()
    {
        super();
        addObject(ironMan, 400 , 100);
    }

    public void act(){
        super.act();
        music.playLoop();
        if(timer.millisElapsed() > 0){
            addObject(title, 400, 200);
        }
        if(timer.millisElapsed() > 4000){
            removeObject(title);
            addObject(main, 400, 1000);
        }
        if(timer.millisElapsed() > 35000){
            removeObject(main);
            addObject(end, 400 ,200);
        }
        if(timer.millisElapsed() > 40200){
            addObject(returnText, 400,250);
        }
        if(Greenfoot.isKeyDown("enter")){
            music.stop();
            Greenfoot.setWorld(new IntroWorld());
        }
    }
}
