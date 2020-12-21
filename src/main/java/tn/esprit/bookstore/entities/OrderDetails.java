package tn.esprit.bookstore.entities;

import javax.persistence.*;

@Entity
public class OrderDetails {

    @EmbeddedId
    private OrderDetailsPK orderDetailsPK;

    @ManyToOne
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private  PBook book;

    private int quantity;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK, int quantity) {
        this.orderDetailsPK = orderDetailsPK;
        this.quantity = quantity;
    }

    public OrderDetailsPK getOrderDetailsPK() {
        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PBook getBook() {
        return book;
    }

    public void setBook(PBook book) {
        this.book = book;
    }
}
