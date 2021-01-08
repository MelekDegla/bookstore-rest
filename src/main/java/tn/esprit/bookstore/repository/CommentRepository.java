package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment,Long> {
}
