package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.dao.ApiKeyDAO;
import com.marticles.airnet.mainservice.model.ApiApplication;
import com.marticles.airnet.mainservice.model.ApiKey;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.util.SnowflakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ApiService
 * @date 2019/3/16
 */
@Service
public class ApiKeyService {

    private final static String HMC_SECRET_KEY = "Marticles";

    @Autowired
    private ApiKeyDAO apiKeyDAO;

    @Autowired
    private UserLocal userLocal;

    public Integer addApiApplication(String reason, String sendEmail) {
        Integer userId = userLocal.getUser().getId();
        String userName = userLocal.getUser().getName();
        Date date = new Date();
        return apiKeyDAO.addApiApplication(reason, sendEmail, userId, userName, date, 0);
    }

    public ApiApplication getApiKeyStatus(Integer userId) {
        return apiKeyDAO.getApiKeyStatus(userId).get(0);
    }

    public ApiKey getApiKey(Integer userId) {
        return apiKeyDAO.getApiKey(userId);
    }

    public List<ApiApplication> getApiApplication() {
        return apiKeyDAO.getApiKeyApplication();
    }

    public void updateApplicationStatus(Integer id, Integer status) {
        apiKeyDAO.updateApplicationStatus(id, status);
    }

    /**
     * 基于Snowflake算法生成唯一ID
     * 再对ID进行HmacMD5加密生成API KEY
     *
     * @param userId
     * @param preSecondRequestLimit
     * @param monthlyRequestLimit
     * @return void
     * @author Marticles
     * @date 2019/3/22
     */
    public void addApiKey(Integer userId, Integer preSecondRequestLimit, Integer monthlyRequestLimit) throws Exception {
        SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(0, 0);
        String uniqueId = String.valueOf(snowflakeIdGenerator.nextId());
        SecretKey secretKey = new SecretKeySpec(HMC_SECRET_KEY.getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(secretKey);
        String key = byteToString(mac.doFinal(uniqueId.getBytes()));
        // API KEY已存在
        if (apiKeyDAO.countApiKey(userId) > 0) {
            apiKeyDAO.updateApiKey(userId, key, preSecondRequestLimit, monthlyRequestLimit);
        } else {
            apiKeyDAO.addApiKey(userId, key, preSecondRequestLimit, monthlyRequestLimit);
        }
    }

    private String byteToString(byte[] digest) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String tempStr = Integer.toHexString(digest[i] & 0xff);
            if (tempStr.length() == 1) {
                buf.append("0").append(tempStr);
            } else {
                buf.append(tempStr);
            }
        }
        return buf.toString().toLowerCase();
    }

}
