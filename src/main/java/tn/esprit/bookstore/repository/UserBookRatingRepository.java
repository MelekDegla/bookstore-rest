package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.UserBookRating;

public interface UserBookRatingRepository extends JpaRepository<UserBookRating, Long> {
}
