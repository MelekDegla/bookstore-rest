package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.OrderDetails;
import tn.esprit.bookstore.entities.OrderDetailsPK;
import tn.esprit.bookstore.repository.OrderDetailsRepository;
import tn.esprit.bookstore.services.IOrderDetailsService;

import java.util.List;

@Service
public class OrderDetailsService implements IOrderDetailsService {


    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }


    @Override
    public OrderDetails findById(OrderDetailsPK id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public void deleteById(OrderDetailsPK id) {
        orderDetailsRepository.deleteById(id);

    }
}