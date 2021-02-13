package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.CanShoot;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Guns.Hittable;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy implements CanShoot, Hittable, Movable{
    protected int health;
    protected Gun gun;
    protected Picture enemyVisual;
    private final int charHeight = Window.getCelSizeY() * 6;
    private final int charWidth = Window.getCelSizeX() * 8;
    private final int charStartPointY = Window.getFLOORCOORD() - charHeight;
    private final int charStartPointX;
    protected int shootSpeed;
    public static Player player; //each enemy must know the player to move according to what the player does

    public Enemy(int charStartPointX) {
        this.charStartPointX = charStartPointX;
        enemyVisual = new Picture(charStartPointX, charStartPointY, "scyco-alien.png");
        enemyVisual.draw();
       // enemyVisual.grow();
       // enemyVisual.fill();
        //enemyVisual.setColor(Color.BLACK);
    }

    public static Player getPlayer() {
        return player;
    }

    @Override
    public void shoot() {
        gun.shootBullet(gun.getBulletDamage());
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean setIsDead(){
        return isDead();
    }

    @Override
    public void hit(Bullet bullet) {
        System.out.println("Entered the hit method of the enemy");
        if(isDead()) {
            //TODO fix enemy dead
            enemyVisual.delete();
            //enemyVisual = null;
            System.out.println("enemy dead");
        }
        if (!isDead()) {
            health -= bullet.getDamage();
            System.out.println(health);
        }
    }

    /*public void play() {
        int xOfPlayer = player.getPlayerVisual().getX();
        int xOfEnemy = this.enemyVisual.getX();
        if (xOfEnemy - xOfPlayer > )
    }*/


    public int getCharHeight() {
        return charHeight;
    }

    public int getCharWidth() {
        return charWidth;
    }

    public int getCharStartPointX() {
        return charStartPointX;
    }

    public int getCharStartPointY() {
        return charStartPointY;
    }

    public Picture getEnemyVisual() {
        return enemyVisual;
    }

    public int getHealth() {
        return health;
    }
}
