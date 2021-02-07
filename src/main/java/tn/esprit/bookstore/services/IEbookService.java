package tn.esprit.bookstore.services;

import tn.esprit.bookstore.entities.EBook;
import tn.esprit.bookstore.entities.PBook;

import java.util.List;

public interface IEbookService {
    EBook save(EBook book);

    EBook findById(Long id);

    List<EBook> findAll();

    void deleteById(Long id);
    List<EBook> findByCategory(Long id );

}
