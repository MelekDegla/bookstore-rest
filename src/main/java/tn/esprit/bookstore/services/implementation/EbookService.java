package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.EBook;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.repository.EbookRepository;
import tn.esprit.bookstore.repository.PbookRepository;
import tn.esprit.bookstore.services.IEbookService;

import java.util.List;
@Service

public class EbookService implements IEbookService {
    final EbookRepository ebookRepository;
    @Autowired
    public EbookService(EbookRepository ebookRepository) {
        this.ebookRepository = ebookRepository;
    }
    @Override
    public EBook save(EBook book){
        return ebookRepository.save(book);
    }
    @Override
    public EBook findById(Long id) {
        return  ebookRepository.findById(id).orElse(null);
    }
    @Override
    public List<EBook> findAll() {
        return ebookRepository.findAll();

    }

    @Override
    public void deleteById(Long id) {
        ebookRepository.deleteById(id);

    }

    @Override
    public List<EBook> findByCategory(Long id) {
        return ebookRepository.findByCategory(id);
    }
}
