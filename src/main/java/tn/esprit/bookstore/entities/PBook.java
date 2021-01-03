package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PBook extends Book {

    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<OrderDetails> orderDetails;
    public PBook(String isbn, String title, String description, String imageUrl, double price, int quantity) {
        super(isbn, title, description, imageUrl, price);
        this.quantity = quantity;
    }

    public PBook() {
        super();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
