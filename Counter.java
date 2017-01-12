import greenfoot.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Scoreboard
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    public int score = 0;
    public void act() 
    {
        GreenfootImage newImage = getImage();
        newImage.clear();
        
        Color bgColor = new Color(0,0,0,0);
        Color textColor = new Color(128,128,0);
        
        Font f = new Font("8BIT WONDER", Font.PLAIN, 12);
        newImage.setFont(f);
        
        newImage.setColor(bgColor);
        newImage.fill();
        newImage.setColor(textColor);
        newImage.drawString("" + score, 10,25);
        setImage(newImage);
    }    

    public void addScore(){
        score++;
    }
    
    public Counter(){
        GreenfootImage newImage = new GreenfootImage(100,40);
        setImage(newImage);
    }
    
    public int getScore(){
        return score;
    }
}
