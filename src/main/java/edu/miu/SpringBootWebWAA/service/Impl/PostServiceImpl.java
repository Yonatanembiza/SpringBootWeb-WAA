package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.repo.PostRepo;
import edu.miu.SpringBootWebWAA.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;
    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findById(int id) {
        return postRepo.findById(id);
    }

    @Override
    public Post save(Post p) {
        return postRepo.save(p);
    }

    @Override
    public Post delete(int id) {
        return postRepo.delete(id);
    }

    @Override
    public Post update(int id, Post p) {
        return postRepo.update(id, p);
    }
}
