package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Category;
import tn.esprit.bookstore.entities.PBook;

import java.util.List;
import java.util.Optional;

@Repository
public interface PbookRepository extends JpaRepository<PBook, Long> {
    @Query(value = "SELECT * FROM book b WHERE b.category_id = ?1", nativeQuery = true)
    List<PBook> findByCategory(Long id);
}
