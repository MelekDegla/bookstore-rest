package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.FeedBack;
import tn.esprit.bookstore.repository.FeedbackRepository;
import tn.esprit.bookstore.services.IFeedbackService;

import java.util.List;
@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    FeedbackRepository fr ;
    @Override
    public FeedBack save(FeedBack feedback) {
        return  fr.save(feedback);
    }

    @Override
    public FeedBack findById(Long id) {
        return fr.findById(id).get();
    }

    @Override
    public List<FeedBack> findAll() {
        return fr.findAll();
    }

    @Override
    public void deleteById(Long id) {
        fr.deleteById(id);

    }
}
