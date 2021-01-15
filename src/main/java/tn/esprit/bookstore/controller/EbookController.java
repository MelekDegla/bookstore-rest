package tn.esprit.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.EBook;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.implementation.EbookService;

import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class EbookController {

    final EbookService ebookService;

    public EbookController(EbookService ebookService ) {
        this.ebookService = ebookService;
    }

    @GetMapping ("listebook")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ebookService.findAll());
    }

    @GetMapping ("byid")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ebookService.findById(id));
    }



    @PostMapping ("addebook")
    public ResponseEntity<?> save(@RequestBody EBook ebook) {
        if (ebook.getId() == null) {
            Optional<EBook> ebook1 = Optional.of(ebookService.save(ebook));
            return ResponseEntity.created(null).body(ebook1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }

    @PutMapping ("update")
    public ResponseEntity<?> update(@RequestBody EBook ebook) {
        if (ebook.getId() != null) {
            EBook ebook1 = ebookService.save(ebook);
            return ResponseEntity.accepted().body(ebook1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
      ebookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping ("cat/{id}")
    public ResponseEntity<?> findByCategory(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(ebookService.findByCategory(id));
    }

}
