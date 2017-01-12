import greenfoot.*;
import java.util.Random;

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    SimpleTimer timer = new SimpleTimer(); //Animation Timer
    SimpleTimer timer2 = new SimpleTimer(); //Air Drop
    SimpleTimer timer3 = new SimpleTimer(); //Ult cooldown
    SimpleTimer timer4 = new SimpleTimer(); //Ult timer
    SimpleTimer timer5 = new SimpleTimer(); //Attack Timer
    SimpleTimer timer7 = new SimpleTimer(); //Summon Animation

    GreenfootSound groundSlam = new GreenfootSound("BossHit.wav");
    GreenfootSound laser = new GreenfootSound("BossLaser.wav");
    GreenfootSound punch = new GreenfootSound("BossPunch.wav");
    GreenfootSound ult = new GreenfootSound("BossUlt.wav");
    GreenfootSound hurt = new GreenfootSound("BossHurt.wav");

    boolean isDead = false; 
    boolean enrage = false; //Ground Checker

    public void act() 
    {
        checkGround();
        if(timer2.millisElapsed() > 5500 && timer3.millisElapsed() > 2000){
            bulletHit();
        }
        //Regular Attacks
        Random r = new Random();
        if(timer2.millisElapsed() > 5500 && timer3.millisElapsed() > 2000){
            walkingAnimation();
            if(r.nextInt(100) < 2){
                punch();
                punch();
                punch();
                punch();
                punch();
                punch();
                move(-4);
                timer.mark();
            }
            if(r.nextInt(100) < 2){
                attack();
                attack();
                attack();
                attack();
                attack();
                attack();	
                timer.mark();
            }
            if(r.nextInt(100) < 2){
                move(-2);
            }
        }
        //Laser Attack
        if(timer5.millisElapsed() > 5500){
            if(timer4.millisElapsed() > 10000){
                ult.setVolume(80);
                ult.play();
                BossUlt ult = new BossUlt();
                getWorld().addObject(ult, getX() - 400, getY() + 3);
                setImage("BossStance4.png");
                timer3.mark();
                timer4.mark();
            } 
        }
    }

    public Boss(){
        setImage("BossSummon1.png");
    }

    /**
     * Checks if boss is on the ground
     */
    public void checkGround(){
        if(isTouching(BossGround.class)){
            setLocation(getX(), getY());
            if(enrage == false){
                summonAnimation();
                summonExplosion();
                if(timer7.millisElapsed() > 2000){
                    enrage = true;
                }
            }
        } else {
            setLocation(getX(), getY() + 3);
        }
    }

    /**
     * Health and bullet interactions
     */
    public void bulletHit(){
        Boss1 world = (Boss1) getWorld();
        boolean getHit = false;
        if(isTouching(Bullet.class)){
            hurt.setVolume(90);
            hurt.play();
            setImage("BossHit.png");
            timer.mark();
            World myWorld = getWorld();
            Boss1 boss = (Boss1)myWorld;
            HealthBar healthBar = boss.getHealthBar();
            if(getHit == false){
                healthBar.loseHealth();
                getHit = true;
                if(healthBar.health <= 0){
                    isDead = true;
                }
                removeTouching(Bullet.class);
            }
        } else {
            getHit = false;
        }
    }

    /**
     * Animation for when boss is summoned
     */
    public void summonAnimation(){
        if(timer.millisElapsed() > 200){
            setImage("BossSummon1.png");
        }
        if(timer.millisElapsed() > 400){
            setImage("BossSummon2.png");
        }
        if(timer.millisElapsed() > 600){
            setImage("BossSummon3.png");
            timer.mark();
        }
    }

    /**
     * Explosion when the boss lands
     */
    public void summonExplosion(){
        groundSlam.setVolume(80);
        groundSlam.play();
        GroundExplosion groundExplosion = new GroundExplosion();
        getWorld().addObject(groundExplosion, getX() - 30, getY() + 800);
    }

    public void punch(){
        punch.setVolume(80);
        punch.play();
        BossFire bossFire = new BossFire();
        setImage("BossPunch.png");
        getWorld().addObject(bossFire, getX() - 130, getY() - 20);
    }

    public void attack(){
        laser.setVolume(80);
        laser.play();
        BossFireAttack fire = new BossFireAttack();
        setImage("BossAttack.png");
        getWorld().addObject(fire, getX() - 40, getY() +3 );
    }

    public void walkingAnimation(){
        if(timer.millisElapsed() > 150){
            setImage("BossStanceDefault.png");
        }
        if(timer.millisElapsed() > 300){
            setImage("BossStanceDefault2.png");
        }
        if(timer.millisElapsed() > 450){
            setImage("BossStanceDefault3.png");
        }
        if(timer.millisElapsed() > 500){
            timer.mark();
        }
    }
}
