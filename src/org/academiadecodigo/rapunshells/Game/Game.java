package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Player.Player;

import java.util.List;

public class Game {
    public static Order.OrderList ordersList = new Order.OrderList();
    public static List orderList = ordersList.getList();
    public static List bulletList = Bullet.BulletList.getList();
    public static final String[] playerOrders = Player.getPlayerOrders();
    

    public static void gameOver() {

    }

    public static void executeOrders(Player player) throws InterruptedException {
        System.out.println("executeOrders");
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
            }

        }

        if(player.isJumping()) {
            player.jumpEvent();
            player.getGun().gunVisualJump();
        }

        for(int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            //mete um loop aqui para a bulletMove se não ela só anda um pixel
            bullet.bulletMove();
        }


        Thread.sleep(300);
        executeOrders(player);
    }
}
