package org.academiadecodigo.rapunshells.Guns;


import org.academiadecodigo.rapunshells.Enemies.Enemy;
import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
import org.academiadecodigo.rapunshells.Player.Player;
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

    public Bullet(int damage, Gun gun) {
        this.gun = gun;
        this.damage = damage;
        //sempre que é criada uma nova bala temos de guardar uma referencia para ela
        bulletList.add(this);
        bulletVisual = new Rectangle(gun.gunVisual.getX(), gun.gunVisual.getY(), 5, 5);//bala tem de sair da posição da gun
        bulletVisual.draw();
        Game.orderList.add(new Order(bulletOrders[0], this));

    }

    public void bulletMove() {
        if(this.gun.getPlayer() != null) {
            bulletVisual.translate(1, 0);
            bulletCollisionDetector();
        }
        else {
            bulletVisual.translate(-1, 0);
            bulletCollisionDetector1();
        }
    }

    // todo bullet will have collision detection, calls Hittable.hit()
    // bulletColisionDetector must know all enemys and the player
    public void bulletCollisionDetector(Enemy enemy) {
        //se tiver um array com todos os inimigos é só fazer um loop por eles todos
        if (bulletVisual.getX() >= enemy.getEnemyVisual().getX() && bulletVisual.getX() <= enemy.getEnemyVisual().getX() + enemy.getCharWidth() && bulletVisual.getY() >= enemy.getEnemyVisual().getY()) {
            enemy.hit(this);
            //TODO bullets need to know all instances of Player & Enemy
        }
    }

    public void bulletCollisionDetector1(Player player) {
        if (bulletVisual.getX() >= player.getPlayerVisual().getX() && bulletVisual.getX() <= player.getPlayerVisual().getX() + player.getCharWidth() && bulletVisual.getY() >= player.getPlayerVisual().getY()) {
            player.hit(this);
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
