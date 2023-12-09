package com.exam.services.impl;

import com.exam.models.User;
import com.exam.models.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

//    get all users
    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }


    //    creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        System.out.println(user);
        User local = this.userRepository.findByUsername(user.getUsername());
        if(local != null){
            System.out.println("User already exist in db");
            throw new Exception("User already exist.");
        }else {
            for (UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
     }
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }
    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

}
