package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.Notification;
import com.marticles.airnet.mainservice.model.Response;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.service.DataService;
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
    UserLocal userLocal;

    @Autowired
    DataService dataService;

    @GetMapping("/notification/{userId}")
    public List<Notification> getSiteUpdatedTime(@RequestHeader(value = "Authorization") String jwtToken,
                                                 @PathVariable Integer userId,
                                                 @RequestParam("read-status") Integer readStatus) {
        List<Notification> notificationList = null;
        notificationList = dataService.getNotifications(jwtToken, userId, readStatus);
        return notificationList;
    }

    @PutMapping("/notification/{id}")
    public Response ReadNotification( @RequestHeader(value = "Authorization") String jwtToken,
                                    @PathVariable Integer id){
        dataService.readNotification(jwtToken, id);
        Response response = new Response();
        response.setCode(200);
        response.setMsg("success");
        return response;
    }

}
