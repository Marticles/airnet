package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.UserDAO;
import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marticles
 * @description LoginServer
 * @date 2019/1/21
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int addUser(UserRequest user){
        return userDAO.addUser(user);
    }

    public User checkUser(UserRequest user) {
        return userDAO.checkUser(user);
    }

    public List<User> getAllUsers(Integer adminId){
        return userDAO.getAllUsers(adminId);
    }

    public void deleteUser(Integer userId){
        userDAO.deleteUser(userId);
    }

    public User getUserById(Integer userId){
        return userDAO.getUserById(userId);
    }

    public void updatedUser(User user){
        userDAO.updatedUser(user);
    }
}
