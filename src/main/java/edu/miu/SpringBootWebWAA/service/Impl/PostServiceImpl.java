package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.entity.output.PostDto;
import edu.miu.SpringBootWebWAA.repo.PostRepo;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepo.findAll();
        List<PostDto> postsDto = new ArrayList<>();
        posts.forEach(new Consumer<Post>() {
            @Override
            public void accept(Post p) {
                postsDto.add(new PostDto(p.getContent(), p.getTitle(), p.getAuthor()));
            }
        });
//        posts.forEach(p -> {
//            postsDto.add(new PostDto(p.getContent(), p.getTitle(), p.getAuthor()));
//        });
        return postsDto;
    }

    @Override
    public PostDto findById(int id) {
        Post post = postRepo.findById(id);
        return new PostDto(post.getContent(), post.getTitle(), post.getAuthor());
    }

    @Override
    public PostDto save(Post p) {
        Post savedPost = postRepo.save(p);
        return new PostDto(savedPost.getContent(), savedPost.getTitle(), savedPost.getAuthor());
    }

    @Override
    public PostDto delete(int id) {
        Post deletedPost = postRepo.delete(id);
        return new PostDto(deletedPost.getContent(), deletedPost.getTitle(), deletedPost.getAuthor());
    }

    @Override
    public PostDto update(int id, Post p) {
        Post updatedPost = postRepo.update(id, p);
        return new PostDto(updatedPost.getContent(), updatedPost.getTitle(), updatedPost.getAuthor());
    }
}
