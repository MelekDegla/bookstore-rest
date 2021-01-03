package tn.esprit.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Order;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IOrderService;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    final IOrderService orderService;


    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Order order){
            if(order.getId() == null){
                Optional<Order> order1 = Optional.of(orderService.save(order));
                return ResponseEntity.created(null).body(order1);
            } else {
                throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
            }

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Order order){
        if(order.getId() != null){
            Order order1 = orderService.save(order);
            return ResponseEntity.accepted().body(order1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
