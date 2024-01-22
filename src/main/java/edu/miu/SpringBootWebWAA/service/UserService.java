package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.Comment;
import edu.miu.SpringBootWebWAA.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(int id);
    User saveUser(User user);
    User updateUser(int id, User user);
    User deleteUserById(int id);
    List<User> findUsersWithMoreThanOnePosts();
    List<User> findUsersWithMoreThanNPosts(int numberOfPosts);
    Comment findCommentByPostIdByUserId(int userId, int postId, int commentId);
}
