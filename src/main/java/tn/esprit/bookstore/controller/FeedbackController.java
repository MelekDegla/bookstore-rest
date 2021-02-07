package tn.esprit.bookstore.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.FeedBack;
import tn.esprit.bookstore.services.IFeedbackService;


import java.util.Optional;

@RestController
@RequestMapping("api/feedbacks")
public class FeedbackController {
    final IFeedbackService feedbackService;


    public FeedbackController(IFeedbackService feedbackService) {
        this. feedbackService =  feedbackService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(feedbackService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody FeedBack feedBack){

            Optional<FeedBack> feedBack1 = Optional.of(feedbackService.save(feedBack));
            return ResponseEntity.created(null).body(feedBack1);


    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FeedBack feedBack){

            FeedBack feedBack1 = feedbackService.save(feedBack);
            return ResponseEntity.accepted().body(feedBack1);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        feedbackService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
