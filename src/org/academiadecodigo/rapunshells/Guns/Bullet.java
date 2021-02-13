package org.academiadecodigo.rapunshells.Guns;


import org.academiadecodigo.rapunshells.Enemies.Enemy;
import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
import org.academiadecodigo.rapunshells.Game.Screen1;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.List;

public class Bullet implements Movable {

    private int damage;
    private Gun gun;
    private Picture bulletVisual;
    private static final String[] bulletOrders = {"bulletMove"};
    private static BulletList bulletList = new BulletList();
    private boolean exist = true;

    public Bullet(int damage, Gun gun) {
        this.gun = gun;
        this.damage = damage;
        bulletList.add(this);
        bulletVisual = new Picture(gun.playerGunVisual.getX(), gun.playerGunVisual.getY(), "bullet-pos.png");
        bulletVisual.draw();
        Game.orderList.add(new Order(bulletOrders[0], this));

    }

    public void bulletMove() {
        if(this.gun.getPlayer() != null) {
            bulletVisual.translate(Window.getCelSizeX() * 4, 0);
            bulletCollisionDetector(Screen1.getSoldier());
        } else {
            bulletVisual.translate(- Window.getCelSizeX() * 2, 0);
            bulletCollisionDetector1(Screen1.getPlayer());
        }
    }

    public void bulletCollisionDetector(Enemy enemy) {
        if (bulletVisual.getX() >= enemy.getEnemyVisual().getX() && bulletVisual.getX() <= enemy.getEnemyVisual().getX() + enemy.getCharWidth()
                && bulletVisual.getY() >= enemy.getEnemyVisual().getY() && (bulletVisual.getY() <= enemy.getEnemyVisual().getY() + enemy.getCharHeight())) {
            System.out.println("bullet touched enemy");
            //bulletVisual.delete();  //quando a bala atinge o inimigo ela não continua a andar
            exist = false;
            enemy.hit(this);
            System.out.println(enemy.getHealth());
        } else if(bulletVisual.getX() /* + bulletSize */ >= Window.getWidth()){
            //bulletVisual.delete(); //TODO transform delete em erase
            exist = false;
        }
    }

    public void bulletCollisionDetector1(Player player) {
        if ((bulletVisual.getX() >= player.getPlayerVisual().getX()) && (bulletVisual.getX() <= player.getPlayerVisual().getX() + player.getCharWidth())
                && (bulletVisual.getY() >= player.getPlayerVisual().getY()) && (bulletVisual.getY() <= player.getPlayerVisual().getY() + player.getCharHeight())) {
            bulletVisual.delete();  //quando a bala atinge o player ela não continua a andar
            player.hit(this);
        } else if(bulletVisual.getX() <= Window.getPADDING()) {
            bulletVisual.delete(); //TODO transform delete em erase
        }
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void translate(double v, double v1) {

    }

    public boolean isExist() {
        return exist;
    }

    public static class BulletList {

        private static final List<Bullet> list = new LinkedList<>();

        public void add(Bullet bullet) {
            list.add(bullet);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public static List<Bullet> getList() {
            return list;
        }
        
        public static void remove() {
            //TODO remove bullet
        }
    }
}
