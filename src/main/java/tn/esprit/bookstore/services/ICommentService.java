package tn.esprit.bookstore.services;

import tn.esprit.bookstore.DTOs.AddCommentDTO;
import tn.esprit.bookstore.DTOs.UpdateCommentDTO;
import tn.esprit.bookstore.entities.Comment;


import java.util.List;

public interface ICommentService {
    public Comment save(AddCommentDTO comment) throws Exception;
    public Comment update(UpdateCommentDTO comment);
    public Comment findById(Long id);
    public List<Comment> findAll();
    public void deleteById(Long id);
    public List<Comment> findByBook(Long id);
}
