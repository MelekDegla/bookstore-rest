package tn.esprit.bookstore.services;


import tn.esprit.bookstore.entities.FeedBack;


import java.util.List;

public interface IFeedbackService {
    public FeedBack save(FeedBack feedback);
    public FeedBack findById(Long id);
    public List<FeedBack> findAll();
    public void deleteById(Long id);

}
