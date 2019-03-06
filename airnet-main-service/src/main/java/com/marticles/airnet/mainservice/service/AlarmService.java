package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.AlarmDAO;
import com.marticles.airnet.mainservice.model.Alarm;
import com.marticles.airnet.mainservice.model.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marticles
 * @description AlarmService
 * @date 2019/3/6
 */
@Service
public class AlarmService {

    @Autowired
    AlarmDAO alarmDAO;

    @Autowired
    UserLocal userLocal;

    public List<Alarm> getAlarmList(){
        return alarmDAO.getAlarmList(userLocal.getUser().getId());
    }
}
