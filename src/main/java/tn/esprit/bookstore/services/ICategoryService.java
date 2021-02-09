package tn.esprit.bookstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.bookstore.entities.Category;

import java.util.List;

public interface ICategoryService {
    public Category save(Category category);
    public Category findById(Long id);
    public List<Category> findAll();
    public void deleteById(Long id);
    public Page<Category> findAll(Pageable pageable);
    public Category getCategoryByName(String name);

}
