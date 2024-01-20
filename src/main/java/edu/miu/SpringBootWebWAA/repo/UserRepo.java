package edu.miu.SpringBootWebWAA.repo;

import edu.miu.SpringBootWebWAA.entity.User_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User_, Integer> {
    @Query("select u from User_ u where size(u.posts)>1 ")
    List<User_> findUsersWithMoreThanOnePosts();
}
