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
    private int bulletImageWidth = 70;

    public Bullet(int damage, Gun gun) {
        this.gun = gun;
        this.damage = damage;
        bulletList.add(this);

       if(gun.getPlayer() != null) {
           int random =  (int) Math.ceil(Math.random() * 4);
           switch (random){
               case 1 :
                   bulletVisual = new Picture(gun.getGunVisual().getX(), gun.getGunVisual().getY(), "bullet-pos2.png");
               case 2 :
                   bulletVisual = new Picture(gun.getGunVisual().getX(), gun.getGunVisual().getY(), "bullet3-pos.png");
               case 3 :
                   bulletVisual = new Picture(gun.getGunVisual().getX(), gun.getGunVisual().getY(), "bullet4-pos.png");
               case 4 :
                   bulletVisual = new Picture(gun.getGunVisual().getX(), gun.getGunVisual().getY(), "bullet-pos.png");
           }


       }else if(gun.getEnemy() != null){
           bulletVisual = new Picture(gun.getGunVisual().getX(), gun.getGunVisual().getY(), "enemies-bullet.png");
       }

        bulletVisual.draw();
        Game.orderList.add(new Order(bulletOrders[0], this));

    }


    public void bulletMove() {
        if(this.gun.getPlayer() != null) {
            bulletVisual.translate(Window.getCelSizeX() * 4, 0);
            bulletCollisionDetector(Screen1.getSoldier());
        } else {
            bulletVisual.translate(- Window.getCelSizeX() * 2, 0);
            bulletCollisionDetector1(Game.getPlayer());
        }
    }

    public void bulletCollisionDetector(Enemy enemy) {
        if (bulletVisual.getX() >= enemy.getEnemyVisual().getX() && bulletVisual.getX() <= enemy.getEnemyVisual().getX() + enemy.getCharWidth()
                && bulletVisual.getY() >= enemy.getEnemyVisual().getY() && (bulletVisual.getY() <= enemy.getEnemyVisual().getY() + enemy.getCharHeight())) {
            System.out.println("bullet touched enemy");
            enemy.hit(this);
            bulletVisual.delete();
            exist = false;
        } else if(bulletVisual.getX() + bulletImageWidth >= Window.getWidth()){
            bulletVisual.delete(); //TODO transform delete em erase
            exist = false;
        }
    }

    public void bulletCollisionDetector1(Player player) {
        if ((bulletVisual.getX() >= player.getPlayerVisual().getX()) && (bulletVisual.getX() <= player.getPlayerVisual().getX() + player.getCharWidth())
                && (bulletVisual.getY() >= player.getPlayerVisual().getY()) && (bulletVisual.getY() <= player.getPlayerVisual().getY() + player.getCharHeight())) {
            bulletVisual.delete();  //quando a bala atinge o player ela não continua a andar
            player.hit(this);
            exist = false;
        } else if(bulletVisual.getX() <= Window.getPADDING()) {
            bulletVisual.delete(); //TODO transform delete em erase
            exist = false;
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

    }
}
