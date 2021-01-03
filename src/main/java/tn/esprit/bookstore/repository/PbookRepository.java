package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.PBook;

public interface PbookRepository extends JpaRepository<PBook, Integer> {

}
