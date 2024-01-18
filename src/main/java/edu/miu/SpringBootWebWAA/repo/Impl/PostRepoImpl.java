package edu.miu.SpringBootWebWAA.repo.Impl;

import edu.miu.SpringBootWebWAA.entity.Post;
import edu.miu.SpringBootWebWAA.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int postId = 1;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(511,"Hello","Greetings", "yonatan");
        Post p2 = new Post(611,"Come here","Order", "Daniel");
        posts.add(p1);
        posts.add(p2);
    }


    public List<Post> findAll(){
        return posts;
    }

    public Post save(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);
        return p;
    }

    @Override
    public Post delete(int id) {
        var post = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
        return post;
    }

    @Override
    public Post update(int id, Post p) {
        Post toUpdate = findById(id);
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        return p;
    }

    public Post findById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
