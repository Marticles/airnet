package com.marticles.airnet.mainserver.server;

import com.marticles.airnet.mainserver.dao.AuthDAO;
import com.marticles.airnet.mainserver.model.User;
import com.marticles.airnet.mainserver.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marticles
 * @description LoginServer
 * @date 2019/1/21
 */
@Service
public class AuthServer {

    @Autowired
    AuthDAO authDAO;


    public int addUser(UserRequest user){
        return authDAO.addUser(user);
    }

    public User checkUser(UserRequest user) {
        return authDAO.checkUser(user);
    }
}
