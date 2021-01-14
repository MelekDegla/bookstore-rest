package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}