package tn.esprit.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Author;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IAuthorService;
import tn.esprit.bookstore.services.ICategoryService;

import java.util.Optional;

@RestController
@RequestMapping("api/author")
public class AuthorController {
    final IAuthorService authorService;


    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("findauthors")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(authorService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){return ResponseEntity.ok(authorService.findById(id));}

    @PostMapping("addauthor")
    public ResponseEntity<?> save(@RequestBody Author author){
        if(author.getId() == null){
            Optional<Author> author1 = Optional.of(authorService.save(author));
            return ResponseEntity.created(null).body(author1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }

    @PutMapping("updateauthor")
    public ResponseEntity<?> update(@RequestBody Author author){
        if(author.getId() != null){
            Author author1 = authorService.save(author);
            return ResponseEntity.accepted().body(author1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
