package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.output.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(int id);

    PostDto save(Post p);

    PostDto delete(int id);

    PostDto update(int id, Post p);
}
