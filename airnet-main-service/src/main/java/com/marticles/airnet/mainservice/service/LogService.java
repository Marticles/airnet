package com.marticles.airnet.mainservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.marticles.airnet.mainservice.dao.LogDAO;
import com.marticles.airnet.mainservice.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Marticles
 * @description LogService
 * @date 2019/3/27
*/
@Service
public class LogService {

    @Autowired
    private LogDAO logDAO;

    public List<Log> getLogs(){
        List<Log> logList = logDAO.getLogs();
        return logList;
    }

    public PageInfo getLogsForPage(Integer pageNum){
        PageHelper.startPage(pageNum, 5);
        List<Log> logList = logDAO.getLogs();
        PageInfo page = new PageInfo(logList);
        return page;
    }

}
