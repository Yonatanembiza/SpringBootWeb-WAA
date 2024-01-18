package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAll();

    public Post findById(int id);

    public Post save(Post p);

    public Post delete(int id);

    public Post update(int id, Post p);
}
