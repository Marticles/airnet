package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.ApiKeyDAO;
import com.marticles.airnet.mainservice.model.ApiApplication;
import com.marticles.airnet.mainservice.model.ApiKey;
import com.marticles.airnet.mainservice.model.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Marticles
 * @description ApiService
 * @date 2019/3/16
 */
@Service
public class ApiKeyService {

    @Autowired
    private ApiKeyDAO apiKeyDAO;

    @Autowired
    private UserLocal userLocal;

    public Integer addApiApplication(String reason, String sendEmail){
        Integer userId = userLocal.getUser().getId();
        String userName = userLocal.getUser().getName();
        Date date = new Date();
        return apiKeyDAO.addApiApplication(reason,sendEmail,userId,userName,date,0);
    }

    public ApiApplication getApiKeyStatus(Integer userId){
        return apiKeyDAO.getApiKeyStatus(userId).get(0);
    }

    public ApiKey getApiKey(Integer userId){
        return apiKeyDAO.getApiKey(userId);
    }
}
