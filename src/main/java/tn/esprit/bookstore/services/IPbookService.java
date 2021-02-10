package tn.esprit.bookstore.services;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.PBook;

import java.util.List;

public interface IPbookService {


    PBook save(PBook book);

    PBook findById(Long id);

    List<PBook> findAll();

    void deleteById(Long id);
  //  List<PBook> findByCategory(Long id );

    public PBook findBookByTitle(String title);

    public List<PBook> showRelatedBooks();
    public List<PBook> getBooksFilteredByCategories(String categoriesList);


}
