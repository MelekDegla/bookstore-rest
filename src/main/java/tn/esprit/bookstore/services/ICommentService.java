package tn.esprit.bookstore.services;

import tn.esprit.bookstore.entities.Comment;


import java.util.List;

public interface ICommentService {
    public Comment save(Comment comment);
    public Comment findById(Long id);
    public List<Comment> findAll();
    public void deleteById(Long id);
}
