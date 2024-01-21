package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.repo.PostRepo;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Override
    public List<Post> findAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post findPostById(int id) {
        Optional<Post> postOptional = postRepo.findById(id);
        return postOptional.orElse(null);
    }

    @Override
    public Post savePost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post updatePost(int id, Post post) {
        Optional<Post> existingPostOptional = postRepo.findById(id);
        if(existingPostOptional.isPresent()){
            Post existingPost = existingPostOptional.get();
            existingPost.setId(post.getId());
            existingPost.setContent(post.getContent());
            existingPost.setTitle(post.getTitle());
            existingPost.setAuthor(post.getAuthor());
            return postRepo.save(existingPost);
        }
        return null;
    }

    @Override
    public Post deletePostById(int id) {
        Optional<Post> existingPostOptional = postRepo.findById(id);
        if(existingPostOptional.isPresent()){
            postRepo.deleteById(id);
            return existingPostOptional.get();
        }
        return null;
    }

    @Override
    public List<Post> findPostsByTitle(String title) {
        return postRepo.findPostsByTitle(title);
    }
}
