package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.User;
import edu.miu.SpringBootWebWAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
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
}
