package com.marticles.airnet.dataservice.service;

import com.marticles.airnet.dataservice.dao.PollutionDAO;
import com.marticles.airnet.dataservice.model.PollutionList;
import com.marticles.airnet.dataservice.model.PollutionResponse;
import com.marticles.airnet.dataservice.model.SinglePollutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Marticles
 * @description PollutionService
 * @date 2019/1/25
 */
@Service
public class PollutionService {

    @Autowired
    PollutionDAO pollutionDAO;


    public List<HashMap<String, Object>> getAllPollutionForApi(String site, Date start, Date end) {
        return pollutionDAO.getAllPollution(site, start, end);
    }

    public PollutionResponse getAllPollution(String site, Date start, Date end) {
        PollutionResponse pollutionResponse = new PollutionResponse();
        List<HashMap<String, Object>> pollutionHashMapList = pollutionDAO.getAllPollution(site, start, end);
        PollutionList pollutionList = new PollutionList();
        List<Integer> aqiList = new ArrayList<>();
        List<Float> coList = new ArrayList<>();
        List<String> levelList = new ArrayList<>();
        List<Float> no2List = new ArrayList<>();
        List<Float> oZoneList = new ArrayList<>();
        List<Float> pm10List = new ArrayList<>();
        List<Float> pm25List = new ArrayList<>();
        List<String> primaryPollutantList = new ArrayList<>();
        List<Float> so2List = new ArrayList<>();
        for (HashMap<String, Object> map : pollutionHashMapList) {
            aqiList.add("".equals(map.get("aqi")) || null == map.get("aqi") ? 0 : Integer.valueOf(map.get("aqi").toString()));
            coList.add("".equals(map.get("co")) || null == map.get("co") ? 0F : Float.valueOf(map.get("co").toString()));
            levelList.add("".equals(map.get("level")) || null == map.get("level") ? "" : map.get("level").toString());
            no2List.add("".equals(map.get("no2")) || null == map.get("no2") ? 0F : Float.valueOf(map.get("no2").toString()));
            oZoneList.add("".equals(map.get("oZone")) || null == map.get("oZone") ? 0F : Float.valueOf(map.get("oZone").toString()));
            pm10List.add("".equals(map.get("pm10")) || null == map.get("pm10") ? 0F : Float.valueOf(map.get("pm10").toString()));
            pm25List.add("".equals(map.get("pm25")) || null == map.get("pm25") ? 0F : Float.valueOf(map.get("pm25").toString()));
            primaryPollutantList.add("".equals(map.get("primaryPollutant")) || null == map.get("primaryPollutant") ? "" : map.get("primaryPollutant").toString());
            so2List.add("".equals(map.get("so2")) || null == map.get("so2") ? 0F : Float.valueOf(map.get("so2").toString()));
        }
        pollutionList.setAqi(aqiList);
        pollutionList.setCo(coList);
        pollutionList.setLevel(levelList);
        pollutionList.setNo2(no2List);
        pollutionList.setOZone(oZoneList);
        pollutionList.setPm10(pm10List);
        pollutionList.setPm25(pm25List);
        pollutionList.setPrimaryPollutant(primaryPollutantList);
        pollutionList.setSo2(so2List);
        pollutionResponse.setPollution(pollutionList);
        pollutionResponse.setTime(pollutionDAO.getTimeRange(site, start, end));
        return pollutionResponse;
    }

    public SinglePollutionResponse getPollution(String site, String pollution, Date start, Date end) {
        SinglePollutionResponse singlePollutionResponse = new SinglePollutionResponse();
        singlePollutionResponse.setPollution(pollutionDAO.getPollution(site, pollution, start, end));
        singlePollutionResponse.setTime(pollutionDAO.getTimeRange(site, start, end));
        singlePollutionResponse.setPollution_name(pollution);
        return singlePollutionResponse;
    }

    public List<HashMap<String, Object>> getPollutionForApi(String site, String pollution, Date start, Date end) {
        return pollutionDAO.getPollutionForApi(site,pollution,start,end);
    }

    public HashMap<String, Object> getSiteUpdatedTime(String site) {
        return pollutionDAO.getSiteUpdatedTime(site);
    }

}
