import greenfoot.*;

/**
 * Write a description of class IronMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IronMan extends Actor
{
    GreenfootSound laser = new GreenfootSound("Laser.aiff");
    GreenfootSound death = new GreenfootSound("Death.wav");

    SimpleTimer bulletTimer = new SimpleTimer(); 
    SimpleTimer animationTimer = new SimpleTimer();
    boolean isDead = false; 

    public void act() 
    {
        checkDead();
        control();
        animate();
    }

    public void checkDead(){
        if(isTouching(Rocket.class)){
            isDead = true;
        }
        if(isTouching(Enemy.class)){
            isDead = true;
        }
        if(isTouching(Enemy2.class)){
            isDead = true;
        }
        if(isTouching(EnemyBullet.class)){
            isDead = true;
        }
        if(isTouching(BossFire.class)){
            isDead = true;
        }
        if(isTouching(BossFireAttack.class)){
            isDead = true;
        }
        if(isTouching(Boss.class)){
            isDead = true;
        }
        if(isTouching(BossUlt.class)){
            isDead = true;
        }
        if(isTouching(Bomb.class)){
            isDead = true;
        }
        if(isTouching(SpaceShip.class)){
            isDead = true;
        }
        if(isTouching(BossRockets.class)){
            isDead = true;
        }
        if(isDead == true){
            death.setVolume(80);
            death.play();
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
        }
    }

    public void control(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 7);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 7);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 7, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 7, getY());
        }
        if(Greenfoot.isKeyDown("space")){
            fire();
            setImage("Flying Laser 2.png");
        }
        if(!Greenfoot.isKeyDown("space")){
            setImage("Flying 1.png");
        }
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

    /**
     * Add a bullet object to the actor's location
     */
    private void fire(){
        if(bulletTimer.millisElapsed() > 300){
            Bullet bullet = new Bullet();
            laser.setVolume(75);
            laser.play();
            getWorld().addObject(bullet, getX() + 40,getY() + 3); 
            bulletTimer.mark();
        }
    }
}

