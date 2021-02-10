package tn.esprit.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.OrderDetails;
import tn.esprit.bookstore.entities.OrderDetailsPK;
import tn.esprit.bookstore.services.implementation.OrderDetailsService;

import java.util.Optional;

@RestController
@RequestMapping("api/order-details")
public class OrderDetailsController {

    final OrderDetailsService orderDetailsService;


    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderDetailsService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderDetails orderDetails){

            Optional<OrderDetails> orderDetails1 = Optional.of(orderDetailsService.save(orderDetails));
            return ResponseEntity.created(null).body(orderDetails1);


    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody OrderDetails orderDetails){
        if(orderDetails.getOrderDetailsPK() != null){
            OrderDetails orderDetails1 = orderDetailsService.save(orderDetails);
            return ResponseEntity.accepted().body(orderDetails1);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{oid}/{}")
    public ResponseEntity<?> delete(@PathVariable("id") OrderDetailsPK id){
        orderDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}