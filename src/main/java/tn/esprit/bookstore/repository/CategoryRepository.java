package tn.esprit.bookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.bookstore.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    @Query("select distinct c from Category c " +
            "left join fetch c.parent pp " +
            "left join fetch c.children ch " +
            "where pp is null")
    List<Category> findAll();

}