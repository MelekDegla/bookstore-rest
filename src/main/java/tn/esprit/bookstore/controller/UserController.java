package tn.esprit.bookstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.exceptions.SavingIdException;
import tn.esprit.bookstore.services.IUserService;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){
        if(user.getId() == null){
            Optional<User> user1 = Optional.of(userService.save(user));
            return ResponseEntity.created(null).body(user1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id must be null");
        }

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user){
        if(user.getId() != null){
            User user1 = userService.save(user);
            return ResponseEntity.accepted().body(user1);
        } else {
            throw new SavingIdException(HttpStatus.BAD_REQUEST, "entity id cannot be null");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
