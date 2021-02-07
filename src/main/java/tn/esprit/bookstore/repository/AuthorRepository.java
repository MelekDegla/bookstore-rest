package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
