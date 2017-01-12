import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    GreenfootSound music = new GreenfootSound("AvengersTheme.mp3");
    GreenfootSound select = new GreenfootSound("Select.wav");

    private static final String bgImageName = "Background.jpg";
    private static final double scrollSpeed = 2.0;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;

    IntroText introText = new IntroText();
    ControlsText controlsText = new ControlsText();
    Controls control = new Controls();
    BackButton backButton = new BackButton();
    StartGame startGame = new StartGame();

    public IntroWorld()
    {    
        super(800, 400, 1);
        setBackground(bgImageName);
        bgImage = new GreenfootImage(getBackground());
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        prepare();
    }

    public void stopMusic(){
        music.stop();
    }

    public void act()
    {
        music.playLoop();
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
        if(startGame.startGame == true){
            select.play();
            music.stop();
            Greenfoot.setWorld(new Stage1());
        }
    }

    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    public void prepare()
    {
        addObject(introText, 415,200);
        addObject(startGame , 410, 140);
        addObject(controlsText, 410, 180);
    }

    public void prepare2(){
        addObject(control, 410, 210);
        addObject(backButton, 410,300);
    }

    public void remove(){
        removeObject(control);
        removeObject(backButton);
    }

    public void remove2(){
        removeObject(introText);
        removeObject(startGame);
        removeObject(controlsText);
    }
}

