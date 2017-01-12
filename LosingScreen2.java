import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class LosingScreen2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LosingScreen2 extends GameWorld2
{
    Counter counter = new Counter();
    LoseText loseText = new LoseText();
    EndGameScore endGameScore = new EndGameScore();
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer timer2 = new SimpleTimer();
    SimpleTimer timer3 = new SimpleTimer();

    GreenfootSound gameOver = new GreenfootSound("GameOver.mp3");
    GreenfootSound music = new GreenfootSound("GuilesTheme.mp3");
    GreenfootSound select = new GreenfootSound("Select.wav");

    public LosingScreen2()
    {    
        super();
        addObject(loseText, 415,200);
        addObject(endGameScore, 630, 370);
    }

    public Counter getCounter(){
        return counter;
    }

    private void spawnSpaceShip(){
        SpaceShip spaceShip = new SpaceShip();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(spaceShip, 800 , 300);
    }

    private void spawnEnemyBullet(){
        EnemyBullet rocket = new EnemyBullet();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(rocket, 800, y);
    }

    public void act()
    {
        super.act();
        gameOver.play();
        addObject(counter, 465,193);
        if(timer.millisElapsed() > 4200){
            gameOver.stop();
            music.setVolume(60);
            music.playLoop();
        }
        Random r = new Random();
        if(timer3.millisElapsed() > 4200){
            if(timer2.millisElapsed() > 5000){
                spawnSpaceShip();
                timer2.mark();
            }
            if(r.nextInt(100) < 2){
                spawnEnemyBullet();
            }
        }
        if(Greenfoot.isKeyDown("enter")){
            select.play();
            gameOver.stop();
            music.stop();
            Greenfoot.setWorld(new Stage1());
        }
    }
}
