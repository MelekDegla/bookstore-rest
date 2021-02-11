package tn.esprit.bookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.DTOs.AddCommentDTO;
import tn.esprit.bookstore.DTOs.UpdateCommentDTO;
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
    @GetMapping("/book/{id}")
    public ResponseEntity<?> findByBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(commentService.findByBook(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AddCommentDTO comment) throws Exception {


        Optional<Comment> comment1 = Optional.of(commentService.save(comment));
        return ResponseEntity.created(null).body(comment1);


    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UpdateCommentDTO comment){

        Comment comment1 = commentService.update(comment);
        if (comment1 != null){
            return ResponseEntity.accepted().body(comment1);
        }
        else {
            return ResponseEntity.accepted().body("sorry you can't update. You are not the owner of this comment!");
        }


    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
