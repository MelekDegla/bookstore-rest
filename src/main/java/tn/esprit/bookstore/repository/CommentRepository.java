package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.bookstore.entities.Comment;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query(value = "select * from review r where book_id = :id and dtype ='Comment'", nativeQuery = true)
    public List<Comment> getbybook(Long id);
}
