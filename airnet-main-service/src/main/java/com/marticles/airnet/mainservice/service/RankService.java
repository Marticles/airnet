package com.marticles.airnet.mainservice.service;


import com.alibaba.fastjson.JSONArray;
import com.marticles.airnet.mainservice.model.CityRank;
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
 * @description RankService
 * @date 2019/2/6
 */
@Service
public class RankService {


    @Autowired
    DataService dataService;

    @Autowired
    private RestTemplate restTemplate;

    public List<CityRank> getCNRank(boolean isReverse) {
        String url = "http://weather.gtimg.cn/aqi/cityrank.json";
        List<CityRank> cityRanks = new ArrayList<>(256);
        List<CityRank> reverseCityRanks = new ArrayList<>(256);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
            String rankBody = responseEntity.getBody().replace("cityrank(", "");
            cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
            reverseCityRanks = cityRanks.subList(cityRanks.size() - 10, cityRanks.size());
            cityRanks = cityRanks.subList(0, 10);
            Collections.reverse(reverseCityRanks);
        }
        if (isReverse) {
            return reverseCityRanks;
        } else {
            return cityRanks;
        }
    }

}
