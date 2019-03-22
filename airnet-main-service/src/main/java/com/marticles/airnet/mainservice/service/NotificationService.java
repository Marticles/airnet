package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.NotificationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Marticles
 * @description NotificationService
 * @date 2019/3/22
 */
@Service
public class NotificationService {

    @Autowired
    private NotificationDAO notificationDAO;

    public void addApiKeyNotification(Integer userId, Integer status) {
        String title = "API Key申请结果通知";
        String subTitle = null;
        String content = null;
        if (status.equals(1)) {
            subTitle = "你的申请已通过";
            content = "请至API说明页中查看API Key";
        } else {
            subTitle = "你的申请已被拒绝";
            content = "建议继续尝试申请";
        }
        notificationDAO.addNotification(userId, title, subTitle, content, 0, new Date());
    }

}
