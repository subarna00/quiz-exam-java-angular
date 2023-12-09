package com.exam.services;

import com.exam.models.User;
import com.exam.models.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
//    create user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
//    get user by username
    public  User getUser(String username);
//    delete user by id
    public  void deleteUser(Long userId);
//    get all users
    public List<User> getUsers();
}
