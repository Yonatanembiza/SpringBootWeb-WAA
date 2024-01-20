package edu.miu.SpringBootWebWAA.service.Impl;

import edu.miu.SpringBootWebWAA.entity.User_;
import edu.miu.SpringBootWebWAA.repo.UserRepo;
import edu.miu.SpringBootWebWAA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User_> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User_ findUserById(int id) {
        Optional<User_> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public User_ saveUser(User_ user) {
        return userRepo.save(user);
    }

    @Override
    public User_ updateUser(int id, User_ user) {
        Optional<User_> existingUserOptional = userRepo.findById(id);
        if(existingUserOptional.isPresent()){
            User_ existingUser = existingUserOptional.get();
            existingUser.setId(user.getId());
            existingUser.setName(user.getName());
            existingUser.setPosts(user.getPosts());
            return userRepo.save(existingUser);
        }
        return null;
    }

    @Override
    public User_ deleteUserById(int id) {
        Optional<User_> existingUserOptional = userRepo.findById(id);
        if(existingUserOptional.isPresent()) {
            userRepo.deleteById(id);
            return existingUserOptional.get();
        }
        return null;
    }
    @Override
    public List<User_> findUsersWithMoreThanOnePosts(){
        return userRepo.findUsersWithMoreThanOnePosts();
    }
}
