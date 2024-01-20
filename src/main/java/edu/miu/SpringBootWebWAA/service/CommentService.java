package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAllComments();
    Comment findCommentById(int id);
    Comment saveComment(Comment comment);
    Comment updateCommentById(int id, Comment comment);
    Comment deleteCommentById(int id);

}
