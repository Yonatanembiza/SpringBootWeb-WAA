package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.LoggingAspect.annotations.ExecutionTime;
import edu.miu.SpringBootWebWAA.entity.Comment;
import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.User;
import edu.miu.SpringBootWebWAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    @ExecutionTime
    public User findUserById(@PathVariable("id") int id){
        return userService.findUserById(id);
    }
    @GetMapping("/{id}/posts")
    public List<Post> findPostsByUserId(@PathVariable("id") int id){
        User user = userService.findUserById(id);
        if(user != null){
            return user.getPosts();
        }
        return null;
    }
    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable("id") int id){
        return userService.deleteUserById(id);
    }
    @GetMapping("/multiple-posts")
    public List<User> findUsersWithMoreThanOnePosts(){
        return userService.findUsersWithMoreThanOnePosts();
    }
    @GetMapping("/multiple-posts-by-number")
    public List<User> findUsersWithMoreThan_n_Posts(@RequestParam int numberOfPosts){
        return userService.findUsersWithMoreThanNPosts(numberOfPosts);
    }
    @GetMapping("/{user_id}/posts/{post_id}/comments/{comment_id}")
    public Comment findCommentByPostIdByUserId(
            @PathVariable("user_id") int user_id,
            @PathVariable("post_id") int post_id,
            @PathVariable("comment_id") int comment_id
    ){
        return userService.findCommentByPostIdByUserId(user_id, post_id, comment_id);
    }
}
