package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.entities.Comment;
import tn.esprit.bookstore.repository.CommentRepository;
import tn.esprit.bookstore.services.ICommentService;

import java.util.List;
@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository cr;
    @Override
    public Comment save(Comment comment) {
        return cr.save(comment);
    }

    @Override
    public Comment findById(Long id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Comment> findAll() {
        return cr.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cr.deleteById(id);

    }
}
