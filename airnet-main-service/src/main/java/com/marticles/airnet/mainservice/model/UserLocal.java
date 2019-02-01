package com.marticles.airnet.mainservice.model;

import org.springframework.stereotype.Component;

/**
 * @author Marticles
 * @description UserLocal
 * @date 2019/1/23
 */
@Component
public class UserLocal {
    private static ThreadLocal<User> userLocal = new ThreadLocal<User>();

    private static ThreadLocal<String> jwtLocal = new ThreadLocal<String>();

    public void setUser(User user){
        userLocal.set(user);
    }

    public User getUser(){
        return userLocal.get();
    }

    public void remove(){
        userLocal.remove();
        jwtLocal.remove();
    }

    public void setJwt(String jwt){
        jwtLocal.set(jwt);
    }

    public String getJwt(){
        return jwtLocal.get();
    }




}
