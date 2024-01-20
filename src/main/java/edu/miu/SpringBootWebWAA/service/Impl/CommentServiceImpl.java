package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.Comment;
import edu.miu.SpringBootWebWAA.repo.CommentRepo;
import edu.miu.SpringBootWebWAA.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentsRepo;
    @Override
    public List<Comment> findAllComments() {
        return commentsRepo.findAll();
    }

    @Override
    public Comment findCommentById(int id) {
        Optional<Comment> existingComment = commentsRepo.findById(id);
        return existingComment.orElse(null);
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentsRepo.save(comment);
    }

    @Override
    public Comment updateCommentById(int id, Comment comment) {
        Optional<Comment> existingCommentOptional = commentsRepo.findById(id);
        if(existingCommentOptional.isPresent()){
            Comment existingComment = existingCommentOptional.get();
            existingComment.setId(comment.getId());
            existingComment.setName(comment.getName());
            existingComment.setPost(comment.getPost());
            return existingComment;
        }
        return null;
    }

    @Override
    public Comment deleteCommentById(int id) {
        Optional<Comment> existingComment =commentsRepo.findById(id);
        if(existingComment.isPresent()){
            commentsRepo.deleteById(id);
            return existingComment.get();
        }
        return null;
    }
}
