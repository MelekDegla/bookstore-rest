package tn.esprit.bookstore.services;


import tn.esprit.bookstore.DTOs.AddFeedbackDTO;
import tn.esprit.bookstore.DTOs.AnswerFeedbackDTO;
import tn.esprit.bookstore.entities.FeedBack;


import java.util.List;

public interface IFeedbackService {
    public FeedBack save(AddFeedbackDTO feedback);
    public FeedBack answer(AnswerFeedbackDTO feedback);
    public FeedBack findById(Long id);
    public List<FeedBack> findAll();
    public void deleteById(Long id);
    public List<FeedBack> search(String recherche);

}
