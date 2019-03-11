package com.marticles.airnet.mailservice.scheduled;

import com.marticles.airnet.mailservice.server.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Marticles
 * @description AlarmJob
 * @date 2019/3/7
 */
@Component
public class AlarmJob {

    @Autowired
    AlarmService alarmService;

//    @Scheduled(cron = "10 * * * * ?")
//    public void checkAlarm(){
//        alarmService.checkAlarm();
//    }

}
