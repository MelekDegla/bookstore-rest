package tn.esprit.bookstore.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name =
        "order_taasmek")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String orderNumber;

    private LocalDate date;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;



    public Order(String orderNumber, LocalDate date) {
        this.orderNumber = orderNumber;
        this.date = date;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
