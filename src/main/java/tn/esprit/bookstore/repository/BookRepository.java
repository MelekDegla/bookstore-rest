package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
