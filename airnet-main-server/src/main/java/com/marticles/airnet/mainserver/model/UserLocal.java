package com.marticles.airnet.mainserver.model;

import org.springframework.stereotype.Component;

/**
 * @author Marticles
 * @description UserLocal
 * @date 2019/1/23
 */
@Component
public class UserLocal {
    private static ThreadLocal<User> userLocal = new ThreadLocal<User>();

    public static void setUser(User user){
        userLocal.set(user);
    }

    public static User getUser(){
        return userLocal.get();
    }

    public static void remove(){
        userLocal.remove();
    }
}
