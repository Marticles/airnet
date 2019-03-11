package com.marticles.airnet.dataservice.controller;

import com.marticles.airnet.dataservice.model.Notification;
import com.marticles.airnet.dataservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marticles
 * @description NotificationController
 * @date 2019/3/10
 */
@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;


    /**
     * 返回用户通知
     * 0：未读
     * 1：已读
     * 2：所有
     *
     * @param userId
     * @param readStatus
     * @return java.util.List<com.marticles.airnet.dataservice.model.Notification>
     * @author Marticles
     * @date 2019/3/10
     */
    @GetMapping("/notification/{userId}")
    public List<Notification> getNotification(@PathVariable Integer userId,
                                                 @RequestParam("read-status") Integer readStatus) {
        List<Notification> notificationList = null;
        if(readStatus.equals(0)){
            notificationList = notificationService.getUnReadNotification(userId);
        }else if(readStatus.equals(2)){
            notificationList = notificationService.getAllNotification(userId);
        }
        return notificationList;
    }


    @PutMapping("/notification/{id}")
    public Integer readNotification(@PathVariable Integer id){
        return notificationService.readNotification(id);
    }

}
