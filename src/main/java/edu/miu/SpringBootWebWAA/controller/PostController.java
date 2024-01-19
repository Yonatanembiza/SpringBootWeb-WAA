package edu.miu.SpringBootWebWAA.controller;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.output.PostDto;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;
    @GetMapping
    public List<PostDto> findAll(){
        return postService.findAll();
    }
    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") int id){
        return postService.findById(id);
    }
    @DeleteMapping("/{id}")
    public PostDto deleteById(@PathVariable("id") int id){
        return postService.delete(id);
    }
    @PostMapping
    public PostDto save(@RequestBody Post p){
        return postService.save(p);
    }
    @PutMapping("/{id}")
    public PostDto update(@PathVariable("id") int id, @RequestBody Post p){
        return postService.update(id, p);
    }
}
