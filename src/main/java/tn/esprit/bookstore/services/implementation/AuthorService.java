package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Author;
import tn.esprit.bookstore.repository.AuthorRepository;
import tn.esprit.bookstore.services.IAuthorService;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {
    final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return  authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return  authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);

    }

    @Override
    public Page<Author> findAll(Pageable pageable) {
        return authorRepository.findAll(pageable);
    }
}
