package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    @Query("select p from Post p where p.title=:title")
    List<Post> findPostsByTitle(@Param("title") String title);
}
