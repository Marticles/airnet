package com.marticles.airnet.apiservice.service;

import com.alibaba.fastjson.JSONArray;
import com.marticles.airnet.apiservice.model.CityRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Marticles
 * @description OtherService
 * @date 2019/3/15
 */
@Service
public class OtherService {

    @Autowired
    private RestTemplate restTemplate;

    public List<CityRank> getCNRank(String order) {
        String url = "http://weather.gtimg.cn/aqi/cityrank.json";
        List<CityRank> cityRanks = new ArrayList<>(256);
        List<CityRank> reverseCityRanks = new ArrayList<>(256);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
            String rankBody = responseEntity.getBody().replace("cityrank(", "");
            cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
            reverseCityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
            Collections.reverse(reverseCityRanks);
        }
        if ("reverse".equals(order)) {
            return  reverseCityRanks;
        } else {
            return cityRanks;
        }
    }
}
