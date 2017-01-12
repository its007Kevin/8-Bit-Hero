import greenfoot.*;
import java.util.Random;
/**
 * Write a description of class LosingScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LosingScreen extends GameWorld
{
    Counter counter = new Counter();
    LoseText loseText = new LoseText();
    EndGameScore endGameScore = new EndGameScore();
    SimpleTimer timer = new SimpleTimer();
    GreenfootSound select = new GreenfootSound("Select.wav");
    GreenfootSound gameOver = new GreenfootSound("GameOver.mp3");
    GreenfootSound music = new GreenfootSound("GuilesTheme.mp3");

    public LosingScreen()
    {    
        super();
        addObject(loseText, 415,200);
        addObject(endGameScore, 630, 370);
    }

    public Counter getCounter(){
        return counter;
    }

    private void spawnEnemyBullet(){
        EnemyBullet rocket = new EnemyBullet();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(rocket, 800, y);
    }

    private void spawnBullet(){
        Bullet bullet = new Bullet();
        Random r = new Random();
        int y = r.nextInt(getHeight());
        addObject(bullet, 0, y);
    }

    public void act()
    {
        super.act();
        gameOver.play();
        addObject(counter, 460, 193);
        if(timer.millisElapsed() > 4200){
            gameOver.stop();
            music.setVolume(60);
            music.playLoop();
        }
        if(timer.millisElapsed() > 4200){
            Random r = new Random();
            if(r.nextInt(70) < 2){
                spawnEnemyBullet();
            }
            if(r.nextInt(70) < 2){
                spawnBullet();
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

