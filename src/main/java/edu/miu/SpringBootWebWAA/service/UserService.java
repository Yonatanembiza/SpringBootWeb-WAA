package edu.miu.SpringBootWebWAA.service;

import edu.miu.SpringBootWebWAA.entity.User_;

import java.util.List;

public interface UserService {
    List<User_> findAllUsers();
    User_ findUserById(int id);
    User_ saveUser(User_ user);
    User_ updateUser(int id, User_ user);
    User_ deleteUserById(int id);
    List<User_> findUsersWithMoreThanOnePosts();
}
