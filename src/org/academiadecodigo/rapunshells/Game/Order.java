package org.academiadecodigo.rapunshells.Game;

import java.util.PriorityQueue;
import java.util.Queue;

public class Order {
    private static final String[] bulletOrders = {"bulletMove"};
    private static final String[] enemyOrders = {"enemyWalkToPlayer", "enemyShoot"};
    private String orderGiven;
    private Object creator;

    public Order(String orderGiven, Object creator) {
        this.orderGiven = orderGiven;
        this.creator = creator;
        //Game.ordersList.add(this);
    }

    public String getOrderGiven() {
        return orderGiven;
    }

    public Object getCreator() {
        return creator;
    }

    public class Container {

        private Queue<Order> queue;

        public Container() {
            queue = new PriorityQueue<>();
        }

        public void add(Order order) {
            queue.add(order);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public Order remove() {
            return queue.remove();
        }

    }
}