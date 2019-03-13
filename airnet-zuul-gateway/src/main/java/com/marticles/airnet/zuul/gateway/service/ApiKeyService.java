package com.marticles.airnet.zuul.gateway.service;

import com.marticles.airnet.zuul.gateway.dao.ApiKeyMapper;
import com.marticles.airnet.zuul.gateway.model.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marticles
 * @description ApiKeyService
 * @date 2019/3/12
 */
@Service
public class ApiKeyService {

    @Autowired
    ApiKeyMapper apiKeyMapper;

    public ApiKey getApiKey(String key){
        if(apiKeyMapper.checkApiKey(key).equals(0)){
            return null;
        }else {
            return apiKeyMapper.getApiKey(key);
        }
    }



}
