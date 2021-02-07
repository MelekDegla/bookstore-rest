package tn.esprit.bookstore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.bookstore.entities.Author;
import tn.esprit.bookstore.entities.Category;

import java.util.List;

public interface IAuthorService {
    public Author save(Author author);
    public Author findById(Long id);
    public List<Author> findAll();
    public void deleteById(Long id);
    public Page<Author> findAll(Pageable pageable);
}
