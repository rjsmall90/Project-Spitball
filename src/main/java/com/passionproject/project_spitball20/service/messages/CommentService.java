package com.passionproject.project_spitball20.service.messages;


import com.passionproject.project_spitball20.model.messages.Comment;
import com.passionproject.project_spitball20.repositories.messages.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;


    public Comment save(Comment comment) {
        comment.setCreated(new Date());
        return commentRepository.save(comment);
    }

    public Comment update(Comment comment) {
        Comment update = commentRepository.findById(comment.getId()).get();
        update.setUpdated(new Date());
        update.setReview(comment.getReview());
        return commentRepository.save(update);

    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
