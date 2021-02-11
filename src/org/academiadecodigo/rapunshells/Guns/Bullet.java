package org.academiadecodigo.rapunshells.Guns;


import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Bullet implements Movable {

    private int damage;
    private Gun gun;
    private Rectangle bulletVisual;
    private static final String[] bulletOrders = {"bulletMove"};
    private static BulletList bulletList;

    public Bullet(int damage,Gun gun) {
        this.gun = gun;
        this.damage = damage;
        bulletList.add(this);
        bulletVisual = new Rectangle(gun.gunVisual.getX(), gun.gunVisual.getY(), 5, 5);//bala tem de sair da posição da gun
        bulletVisual.draw();
        Game.orderList.add(new Order(bulletOrders[0], this));
    }

    public void bulletMove() {
            bulletVisual.translate(1, 0);
            //bulletCollisionDetector();
            //todo time
        }

    // todo bullet will have collision detection, calls Hittable.hit()
    public void bulletCollisionDetector(Soldier soldier) {
        if (bulletVisual.getX() >= soldier.getSoldierVisual().getX()) {
            soldier.hit(this);
        }
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void translate(double v, double v1) {

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
