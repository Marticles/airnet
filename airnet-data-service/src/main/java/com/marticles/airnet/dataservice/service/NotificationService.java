package com.marticles.airnet.dataservice.service;

import com.marticles.airnet.dataservice.dao.NotificationDAO;
import com.marticles.airnet.dataservice.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marticles
 * @description NotificationServer
 * @date 2019/3/10
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationDAO notificationDAO;

    public List<Notification> getUnReadNotification(Integer userId){
        return notificationDAO.getUnReadNotification(userId);
    }

    public List<Notification> getAllNotification(Integer userId){
        return notificationDAO.getAllNotification(userId);
    }

    public Integer readNotification(Integer id){
        return notificationDAO.readNotification(id);
    }

}
