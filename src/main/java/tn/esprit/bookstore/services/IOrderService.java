package tn.esprit.bookstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Order;

import java.util.List;


public interface IOrderService {

    public Order save(Order order);
    public Order findById(Long id);
    public List<Order> findAll();
    public void deleteById(Long id);
    public Page<Order> findAll(Pageable pageable);
}
