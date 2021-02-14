package org.academiadecodigo.rapunshells.Game;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private String orderGiven;
    private Object creator;

    public Order(String orderGiven, Object creator) {
        this.orderGiven = orderGiven;
        this.creator = creator;
    }

    public String getOrderGiven() {
        return orderGiven;
    }

    public Object getCreator() {
        return creator;
    }

    public static class OrderList {

        private final List<Order> list = new LinkedList<>();

        public void add(Order order) {
            list.add(order);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public List<Order> getList() {
            return list;
        }
    }
}