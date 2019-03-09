package com.marticles.airnet.mailservice.scheduledjob;

import com.marticles.airnet.mailservice.server.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TODO 多线程遍历任务List
 *
 * @author Marticles
 * @description AlarmJob
 * @date 2019/3/7
 */
@Component
public class AlarmJob {

    @Autowired
    AlarmService alarmService;

    @Scheduled(cron = "10 * * * * ?")
    public void checkAlarm(){
        // alarmService.checkAlarm();
    }

    @Async
    public void sendAlarm(){

    }

}
