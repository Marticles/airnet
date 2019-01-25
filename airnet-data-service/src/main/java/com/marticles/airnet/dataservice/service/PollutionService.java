package com.marticles.airnet.dataservice.service;

import com.marticles.airnet.dataservice.dao.PollutionDAO;
import com.marticles.airnet.dataservice.model.PollutionResponse;
import com.marticles.airnet.dataservice.model.SinglePollutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Marticles
 * @description PollutionService
 * @date 2019/1/25
 */
@Service
public class PollutionService {

    @Autowired
    PollutionDAO pollutionDAO;

    public PollutionResponse getAllPollution(String site, Date start, Date end) {
        PollutionResponse pollutionResponse = new PollutionResponse();
        pollutionResponse.setPollution(pollutionDAO.getAllPollution(site, start, end));
        pollutionResponse.setTime(pollutionDAO.getTimeRange(site, start, end));
        return pollutionResponse;
    }

    public SinglePollutionResponse getPollution(String site, String pollution, Date start, Date end) {
        SinglePollutionResponse singlePollutionResponse = new SinglePollutionResponse();
        singlePollutionResponse.setPollution(pollutionDAO.getPollution(site, pollution, start, end));
        singlePollutionResponse.setTime(pollutionDAO.getTimeRange(site, start, end));
        return singlePollutionResponse;
    }

    public HashMap<String, Object> getSiteUpdatedTime(String site) {
        return pollutionDAO.getSiteUpdatedTime(site);
    }

}
