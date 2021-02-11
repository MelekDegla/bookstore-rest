package tn.esprit.bookstore.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Comment;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {

}
