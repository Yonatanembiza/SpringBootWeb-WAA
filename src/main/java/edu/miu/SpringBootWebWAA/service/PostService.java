package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    Post findPostById(int id);
    Post savePost(Post post);
    Post updatePost(int id, Post post);
    Post deletePostById(int id);
    List<Post> findPostsByTitle(String title);
}
