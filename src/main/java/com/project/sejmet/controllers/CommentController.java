package com.project.sejmet.controllers;

import com.project.sejmet.entities.Comment;
import com.project.sejmet.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;


    @GetMapping
    public List<Comment> getCommentAll() {
        return commentRepository.findAll();
    }


    @GetMapping("/{id}")
    public Comment getCommentbyId(@PathVariable int id) {

        Optional<Comment> comment = commentRepository.findById(id);

        if (comment.isPresent()) {
            return comment.get();
        }

        return null;
    }


    @PostMapping
    public Comment postComment(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }


    @PutMapping("/{id}")
    public Comment putCommentbyId(@PathVariable int id, @RequestBody Comment comment) {

        Optional<Comment> commentCurrent = commentRepository.findById(id);

        if (commentCurrent.isPresent()) {
            Comment commentReturn = commentCurrent.get();

            commentReturn.setSaleProduct(comment.getSaleProduct());
            commentReturn.setUser(comment.getUser());
            commentReturn.setStrComment(comment.getStrComment());
            commentReturn.setScore(comment.getScore());

            commentRepository.save(commentReturn);
            return commentReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Comment deleteCommentbyId(@PathVariable int id) {

        Optional<Comment> comment = commentRepository.findById(id);

        if (comment.isPresent()) {
            Comment commentReturn = comment.get();
            commentRepository.deleteById(id);
            return commentReturn;
        }

        return null;
    }
}
