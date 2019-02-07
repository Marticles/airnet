package com.marticles.airnet.dataservice.service;

import com.marticles.airnet.dataservice.dao.RankDAO;
import com.marticles.airnet.dataservice.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description RankService
 * @date 2019/2/7
 */
@Service
public class RankService {

    @Autowired
    RankDAO rankDAO;

    public List<Rank> getSiteRanks( Date time,String order){
        List<Rank> rankList = rankDAO.getSiteRanks(time);
        Collections.sort(rankList);
        if("reverse".equals(order)){
            Collections.reverse(rankList);
        }
        return rankList;
    }
}
