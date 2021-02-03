package tn.esprit.bookstore.services;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.bookstore.entities.PBook;

import java.util.List;

public interface IPbookService {


    PBook save(PBook book);

    PBook findById(Long id);

    List<PBook> findAll();

    void deleteById(Long id);
    List<PBook> findByCategory(Long id );

}
