package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.User_;
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
    public List<User_> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public User_ findUserById(@PathVariable("id") int id){
        return userService.findUserById(id);
    }
    @GetMapping("/{id}/posts")
    public List<Post> findPostsByUserId(@PathVariable("id") int id){
        User_ user = userService.findUserById(id);
        if(user != null){
            return user.getPosts();
        }
        return null;
    }
    @PostMapping
    public User_ saveUser(@RequestBody User_ user){
        return userService.saveUser(user);
    }
    @PutMapping("/{id}")
    public User_ updateUser(@PathVariable("id") int id, @RequestBody User_ user){
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/{id}")
    public User_ deleteUserById(@PathVariable("id") int id){
        return userService.deleteUserById(id);
    }
    @GetMapping("/multiple-posts")
    public List<User_> findUsersWithMoreThanOnePosts(){
        return userService.findUsersWithMoreThanOnePosts();
    }
}
