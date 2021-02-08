package tn.esprit.bookstore.services;

import tn.esprit.bookstore.entities.OrderDetails;
import tn.esprit.bookstore.entities.OrderDetailsPK;

import java.util.List;

public interface IOrderDetailsService {
    public OrderDetails save(OrderDetails orderDetails);
    public OrderDetails findById(OrderDetailsPK id);
    public List<OrderDetails> findAll();
    public void deleteById(OrderDetailsPK id);
}
