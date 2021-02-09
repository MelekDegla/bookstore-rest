package tn.esprit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.entities.UserBookRating;
import tn.esprit.bookstore.entities.UserBookRatingKey;
import tn.esprit.bookstore.exceptions.ResourceNotFoundException;
import tn.esprit.bookstore.repository.PbookRepository;
import tn.esprit.bookstore.repository.UserBookRatingRepository;
import tn.esprit.bookstore.repository.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/rates")
public class UserBookRatingController {

    @Autowired
    private UserBookRatingRepository userBookRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PbookRepository bookRepository;

    @GetMapping(value = "/ratedbooks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getUserRatedBooks(@RequestParam("userId") long userId)
            throws ResourceNotFoundException {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        return ResponseEntity.ok().body(user.toString());
    }

    /**
     * Update user response entity.
     *
     * @param userId    the user id
     * @param bookRates the rates of the books
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping(value = "/bookrates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity rateBooks(
            @RequestParam("userId") Long userId, @Valid @RequestBody List<HashMap> bookRates)
            throws ResourceNotFoundException {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found!"));

        List<UserBookRating> updatedBookRates = new ArrayList<>();

        for (HashMap map : bookRates) {
            long bookASIN = Long.parseLong(map.get("asin").toString());
            int rate = Integer.parseInt(map.get("rate").toString());
            Book book =
                    bookRepository
                            .findById(bookASIN)
                            .orElseThrow(() -> new ResourceNotFoundException("Book not found!"));

            UserBookRating userBookRating = new UserBookRating(user, book);
            UserBookRatingKey userBookRatingKey = new UserBookRatingKey(userId, bookASIN);

            userBookRating.setId(userBookRatingKey);
            userBookRating.setRate(rate);
            updatedBookRates.add(userBookRating);

        }

        return ResponseEntity.ok().body(userBookRatingRepository.saveAll(updatedBookRates).toString());
    }
}
