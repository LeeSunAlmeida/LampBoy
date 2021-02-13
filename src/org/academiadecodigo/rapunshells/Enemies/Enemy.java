package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
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
    private static final String[] enemyOrders = {"enemyWalkToPlayer", "enemyShoot", "enemyWalkAwayFromPlayer"};
    private int enemyMoveIterator = 0;

    public Enemy(int charStartPointX) {
        this.charStartPointX = charStartPointX;
        enemyVisual = new Picture(charStartPointX, charStartPointY, "scyco-alien.png");
        enemyVisual.draw();
       // enemyVisual.grow();
       // enemyVisual.fill();
       // enemyVisual.setColor(Color.BLACK);
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

    public void play() {
        int xOfPlayer = player.getPlayerVisual().getX();
        int xOfEnemy = this.enemyVisual.getX();
        if (xOfEnemy - xOfPlayer > 600) {
            for (int i=0; i<5; i++) {
                Game.orderList.add(new Order(enemyOrders[0], this));
                //this.enemyVisual.translate(-1,0);
            }
            Game.orderList.add(new Order(enemyOrders[1], this));
            //this.shoot();
        }
        else {
            for (int i=0; i<5; i++) {
                Game.orderList.add(new Order(enemyOrders[2], this));
                //this.enemyVisual.translate(1,0);
            }
            Game.orderList.add(new Order(enemyOrders[1], this));
            //this.shoot();
        }
    }


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

    public static String[] getEnemyOrders() {
        return enemyOrders;
    }
}
