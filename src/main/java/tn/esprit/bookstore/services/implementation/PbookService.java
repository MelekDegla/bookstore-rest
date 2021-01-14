package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.repository.PbookRepository;
import tn.esprit.bookstore.services.IPbookService;

import java.util.List;

@Service
public class PbookService implements IPbookService {
    final PbookRepository pbookRepository;
    @Autowired
    public PbookService(PbookRepository pbookRepository) {
        this.pbookRepository = pbookRepository;
    }
    @Override
    public PBook save(PBook book){
        return pbookRepository.save(book);
    }
    @Override
    public PBook findById(Long id) {
        return  pbookRepository.findById(id).orElse(null);
    }
    @Override
    public List<PBook> findAll() {
        return pbookRepository.findAll();

    }
    @Override
    public void deleteById(Long id) {
        pbookRepository.deleteById(id);

    }

    @Override
    public List<PBook> findByCategory(Long id) {
        return  pbookRepository.findByCategory(id);

    }

}
