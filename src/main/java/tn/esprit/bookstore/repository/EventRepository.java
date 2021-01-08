package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long> {
}
