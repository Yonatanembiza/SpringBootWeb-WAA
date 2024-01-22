package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.Comment;
import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.User;
import edu.miu.SpringBootWebWAA.repo.UserRepo;
import edu.miu.SpringBootWebWAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        Optional<User> existingUserOptional = userRepo.findById(id);
        if(existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            existingUser.setId(user.getId());
            existingUser.setName(user.getName());
            existingUser.setPosts(user.getPosts());
            return userRepo.save(existingUser);
        }
        return null;
    }

    @Override
    public User deleteUserById(int id) {
        Optional<User> existingUserOptional = userRepo.findById(id);
        if(existingUserOptional.isPresent()) {
            userRepo.deleteById(id);
            return existingUserOptional.get();
        }
        return null;
    }
    @Override
    public List<User> findUsersWithMoreThanOnePosts(){
        return userRepo.findUsersWithMoreThanOnePosts();
    }

    @Override
    public List<User> findUsersWithMoreThanNPosts(int numberOfPosts) {
        return userRepo.findUsersWithMoreThanNPosts(numberOfPosts);
    }

    @Override
    public Comment findCommentByPostIdByUserId(int userId, int postId, int commentId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            Optional<Post> optionalPost = user.getPosts()
                    .stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst();
            if(optionalPost.isPresent()){
                Post post = optionalPost.get();
                Optional<Comment> optionalComment = post.getComments()
                        .stream()
                        .filter(comment -> comment.getId() == commentId)
                        .findFirst();
                return optionalComment.orElse(null);
            }
        }
        return null;
    }
}
