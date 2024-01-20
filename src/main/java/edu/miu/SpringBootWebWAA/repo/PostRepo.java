package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
