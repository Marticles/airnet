package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.AuthDAO;
import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marticles
 * @description LoginServer
 * @date 2019/1/21
 */
@Service
public class AuthService {

    @Autowired
    AuthDAO authDAO;


    public int addUser(UserRequest user){
        return authDAO.addUser(user);
    }

    public User checkUser(UserRequest user) {
        return authDAO.checkUser(user);
    }
}
