package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Player.Player;

public class Game {
    public static Order.Container ordersList;

    public static void gameOver() {

    }

    public static void executeOrders() throws InterruptedException {
        while (!ordersList.isEmpty()) {
            Order order = ordersList.remove();
            String orderStr = order.getOrderGiven();
            Object creator = order.getCreator();
            String[] playerOrders = Player.getPlayerOrders();
            if (orderStr.equals(playerOrders[0])) {
                Player player = (Player) creator;
                if (!player.isJumping()) {
                    player.jumpEvent();
                    //TODO continue with jumpsequence
                }
            } else if (orderStr.equals(playerOrders[1])) {
                Player player = (Player) creator;
                player.duck();
            } else if (orderStr.equals(playerOrders[2])) {
                Player player = (Player) creator;
                player.unDuck();
            } else if (orderStr.equals(playerOrders[3])) {
                Player player = (Player) creator;
                player.moveLeft();
            } else if (orderStr.equals(playerOrders[4])) {
                Player player = (Player) creator;
                player.moveRight();
            } else if (orderStr.equals(playerOrders[5])) {
                Player player = (Player) creator;
                player.shoot();
            }
        }
        Thread.sleep(100);
    }
}
