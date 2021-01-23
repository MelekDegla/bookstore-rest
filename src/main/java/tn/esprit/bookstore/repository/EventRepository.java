package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
