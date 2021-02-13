package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Enemies.Enemy;
import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Player.Player;


import java.util.List;

public class Game {
    public static Order.OrderList ordersList = new Order.OrderList();
    public static List orderList = ordersList.getList();
    public static List bulletList = Bullet.BulletList.getList();
    public static List enemiesAlive = Enemy.EnemyList.getList();
    public static final String[] playerOrders = Player.getPlayerOrders();
    public static final String[] enemyOrders = Enemy.getEnemyOrders();

    

    public static void gameOver() {

    }

    public static void executeOrders(Player player) throws InterruptedException {
        while (!orderList.isEmpty()) {
            System.out.println("order picked");
            Order order = (Order) orderList.get(0);
            orderList.remove(0);
            String orderStr = order.getOrderGiven();
            Object creator = order.getCreator();

            if (orderStr.equals(playerOrders[0])) {
                Player playerCreator = (Player) creator;
                playerCreator.jumpStart();
            } else if (orderStr.equals(playerOrders[1])) {
                Player playerCreator = (Player) creator;
                playerCreator.duck();
            } else if (orderStr.equals(playerOrders[2])) {
                Player playerCreator = (Player) creator;
                playerCreator.unDuck();
            } else if (orderStr.equals(playerOrders[3])) {
                Player playerCreator = (Player) creator;
                playerCreator.moveLeft();
            } else if (orderStr.equals(playerOrders[4])) {
                Player playerCreator = (Player) creator;
                playerCreator.moveRight();
            } else if (orderStr.equals(playerOrders[5])) {
                Player playerCreator = (Player) creator;
                playerCreator.shoot();
                System.out.println("Player.shoot() Order");
            } else if (orderStr.equals(enemyOrders[0])) {
                Enemy enemyCreator = (Enemy) creator;
                enemyCreator.moveToPlayer();
            } else if (orderStr.equals(enemyOrders[1])) {
                Enemy enemyCreator = (Enemy) creator;
                enemyCreator.moveFromPlayer();
            } else if (orderStr.equals(enemyOrders[2])) {
                Enemy enemyCreator = (Enemy) creator;
                enemyCreator.shoot();
            } else if (orderStr.equals(enemyOrders[3])) {
                Enemy enemyCreator = (Enemy) creator;
                enemiesAlive.add(enemyCreator);
            }

        }

        //Jumpchecker
        if(player.isJumping()) {
            player.jumpEvent();
            player.getGun().gunVisualJump();
        }

        //Get all bullets moving once
        for(int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            bullet.bulletMove();
            if(!bullet.isExist()){
                bulletList.remove(i);
            }
        }

        //action all enemies
        for(int i = 0; i < enemiesAlive.size(); i++) {
            Enemy enemy = (Enemy) enemiesAlive.get(i);
            enemy.play();
            if(enemy.isDead()){
                enemiesAlive.remove(i);
            }
        }

        Thread.sleep(50);
        executeOrders(player);
    }
}
