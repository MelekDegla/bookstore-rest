package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Event;
import tn.esprit.bookstore.repository.EventRepository;
import tn.esprit.bookstore.services.IEventService;

import java.util.List;
@Service
public class EventService implements IEventService {
    final EventRepository eventRepository ;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event add(Event event) {
      return  eventRepository.save(event);
    }

    @Override
    public void deletEventById(Long Id) {
         eventRepository.deleteById(Id);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }


    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    //@Override
   // public List<Event> findByTitle(String title) {
       // return eventRepository.f;
  //  }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }
}
