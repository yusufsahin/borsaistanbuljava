package models;

import models.enums.OrderType;
import models.enums.OrderStatus;

public class Order {
    private final Stock stock;
    private final int quantity;
    private final OrderType type;
    private OrderStatus status;

    public Order(Stock stock, int quantity, OrderType type) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Adet sıfır veya negatif olamaz.");
        }
        this.stock = stock;
        this.quantity = quantity;
        this.type = type;
        this.status = OrderStatus.BEKLEYEN;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderType getType() {
        return type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void completeOrder() {
        this.status = OrderStatus.TAMAMLANDI;
    }

    public void cancelOrder() {
        this.status = OrderStatus.IPTAL_EDILDI;
    }

    @Override
    public String toString() {
        return "Order{" +
                "stock=" + stock +
                ", quantity=" + quantity +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && stock.equals(order.stock) && type == order.type && status == order.status;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(stock, quantity, type, status);
    }
}
