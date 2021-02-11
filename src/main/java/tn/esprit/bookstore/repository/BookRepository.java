package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
