package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.repo.PostRepo;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> findAll(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public Post findById(@PathVariable("id") int id){
        return postService.findById(id);
    }
}
