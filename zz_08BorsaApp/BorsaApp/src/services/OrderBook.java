package services;

import models.Order;

import java.util.PriorityQueue;
import java.util.Queue;

public class OrderBook {
    private final Queue<Order> orderQueue;

    public OrderBook() {
        this.orderQueue = new PriorityQueue<>((o1, o2) -> o2.getQuantity() - o1.getQuantity());
    }

    public void placeOrder(Order order) {
        orderQueue.add(order);
    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            System.out.println("İşlenen Emir: " + order);
        }
    }
}
