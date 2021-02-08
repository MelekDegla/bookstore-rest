package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.OrderDetails;
import tn.esprit.bookstore.entities.OrderDetailsPK;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailsPK> {
}
