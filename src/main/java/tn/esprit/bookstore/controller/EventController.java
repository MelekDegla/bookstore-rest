package tn.esprit.bookstore.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Event;
import tn.esprit.bookstore.entities.Order;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IEventService;

import java.util.Optional;

@RestController
@RequestMapping("api/events")
public class EventController {
    final IEventService eventService;

    public EventController(IEventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(eventService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Event event){

            Optional<Event> event1 = Optional.of(eventService.add(event));
            return ResponseEntity.created(null).body(event1);


    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Event event){

            Event event1 = eventService.update(event);
            return ResponseEntity.accepted().body(event1);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        eventService.deletEventById(id);
        return ResponseEntity.noContent().build();
    }


}
