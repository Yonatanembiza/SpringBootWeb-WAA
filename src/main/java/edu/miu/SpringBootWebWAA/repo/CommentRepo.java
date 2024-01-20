package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
