package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping
    public List<Post> findAllPosts(){
            return postService.findAllPosts();
        }
    @GetMapping("/{id}")
    public Post findPostById(@PathVariable("id") int id){
        return postService.findPostById(id);
    }
    @PostMapping
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable("id") int id, @RequestBody Post post){
        return postService.updatePost(id, post);
    }
    @DeleteMapping("/{id}")
    public Post deletePostById(@PathVariable("id") int id){
        return postService.deletePostById(id);
    }
}
