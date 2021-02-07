package tn.esprit.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Comment;
import tn.esprit.bookstore.services.ICommentService;
import java.util.Optional;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    final ICommentService commentService;


    public CommentController(ICommentService commentService) {
        this. commentService =  commentService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(commentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Comment comment){

        Optional<Comment> comment1 = Optional.of(commentService.save(comment));
        return ResponseEntity.created(null).body(comment1);


    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Comment comment){

        Comment comment1 = commentService.save(comment);
        return ResponseEntity.accepted().body(comment1);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
