package tn.esprit.bookstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.bookstore.entities.Event;
import tn.esprit.bookstore.entities.Order;

import java.util.List;

public interface IEventService {
    public Event add(Event event);
    public void deletEventById(Long Id);
    public Event findById(Long id);
    public List<Event> findAll();
  //  public List<Event> findByTitle(String title);
    public Event update (Event event);


}
