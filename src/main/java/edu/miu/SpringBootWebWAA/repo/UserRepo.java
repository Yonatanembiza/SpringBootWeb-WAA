package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("select u from User u where size(u.posts)>1 ")
    List<User> findUsersWithMoreThanOnePosts();
    @Query("select u from User u where size(u.posts)>:numberOfPosts")
    List<User> findUsersWithMoreThanNPosts(@Param("numberOfPosts") int numberOfPosts);
    @Query("select u from User u join u.posts p where p.title=:title")
    List<User> findUsersPostedByTitle(@Param("title") String title);
}
