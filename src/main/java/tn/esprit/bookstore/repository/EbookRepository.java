package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.EBook;

import java.util.List;

@Repository
public interface EbookRepository extends JpaRepository<EBook, Long> {
    @Query(value = "SELECT * FROM book b WHERE b.category_id = ?1", nativeQuery = true)
    List<EBook> findByCategory(Long id);


}

