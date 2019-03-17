package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.UserDAO;
import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marticles
 * @description AdminService
 * @date 2019/3/17
 */
@Service
public class AdminService {

    @Autowired
    private UserDAO userDAO;

    public User checkAdmin(String name,String password){
        UserRequest userRequest = new UserRequest();
        userRequest.setName(name);
        userRequest.setPassword(password);
        return  userDAO.checkUser(userRequest);
    }


}
