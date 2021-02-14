package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
import org.academiadecodigo.rapunshells.Game.Screen1;
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

import java.util.LinkedList;
import java.util.List;

public abstract class Enemy implements CanShoot, Hittable, Movable{
    protected int health;
    protected Gun gun;
    protected Picture enemyVisual;
    private final int charHeight = Window.getCharHeight();
    private final int charWidth = Window.getCharWidth();
    private final int charStartPointY = Window.getFLOORCOORD() - Window.getCelSizeY() *6;
    private final int charStartPointX;
    protected int shootSpeed;
    private static final String[] enemyOrders = {"enemyWalkToPlayer", "enemyWalkAwayFromPlayer", "enemyShoot", "addEnemyToOrders", "feedLoop"};
    private int enemyMoveIterator = 0;
    private Player player = Game.getPlayer();

    public Enemy(int charStartPointX) {
        this.charStartPointX = charStartPointX;
        Game.orderList.add(new Order(enemyOrders[3], this));
        System.out.println("created");
    }

    public void drawEnemy() {
        enemyVisual = new Picture(charStartPointX, charStartPointY, "alien-talefe.png");
        enemyVisual.draw();
    }

    @Override
    public void shoot() {
        if(!isDead()) {
            gun.shootBullet(gun.getBulletDamage());
        }
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean setIsDead(){
        return isDead();
    }

    @Override
    public void hit(Bullet bullet) {
        System.out.println(isDead());
        if(isDead()) {
            enemyVisual.delete();
             Screen1.Final();
        }
        if (!isDead()) {
            health -= bullet.getDamage();
        }
    }

    public void play() {
        int xOfPlayer = player.getPlayerVisual().getX();
        System.out.println("enemy move");
        if(enemyMoveIterator % 2 == 0) {
            if(enemyVisual.getMaxX() < Window.getWidth()) {
                if (enemyVisual.getX() > xOfPlayer + Window.getCelSizeX() * 100) {
                    Game.orderList.add(new Order(enemyOrders[0], this)); //walk to player
                } else if (enemyVisual.getX() < xOfPlayer + Window.getCelSizeX() * 60) {
                    Game.orderList.add(new Order(enemyOrders[1], this)); //from
                }
            }
        }
        if (enemyMoveIterator > 12) {
            double random = Math.random() * 20;
            if(random > 18) {
                Game.orderList.add(new Order(enemyOrders[2], this));
                enemyMoveIterator = 0;
            }
        }
        enemyMoveIterator++;
    }

    public void moveToPlayer() {
        enemyVisual.translate(-Window.getCelSizeX(), 0);
        gun.getGunVisual().translate(-Window.getCelSizeX(), 0);
    }

    public void moveFromPlayer() {
        enemyVisual.translate(Window.getCelSizeX(), 0);
        gun.getGunVisual().translate(Window.getCelSizeX(), 0);
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



    public static class EnemyList {

        private static final List<Enemy> list = new LinkedList<>();

        public void add(Enemy enemy) {
            list.add(enemy);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public static List<Enemy> getList() {
            return list;
        }



    }


}
