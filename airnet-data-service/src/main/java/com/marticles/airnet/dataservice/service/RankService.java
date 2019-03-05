package com.marticles.airnet.dataservice.service;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.dataservice.dao.RankDAO;
import com.marticles.airnet.dataservice.model.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Marticles
 * @description RankService
 * @date 2019/2/7
 */
@Service
public class RankService {

    private final String RANK_PREFIX = "Rank-";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    RankDAO rankDAO;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Rank> getSiteRanks(Date time, String order) {
        List<Rank> rankList = null;
        if (stringRedisTemplate.hasKey(RANK_PREFIX + SIMPLE_DATE_FORMAT.format(time))) {
            String rankString = stringRedisTemplate.opsForValue().get(RANK_PREFIX + SIMPLE_DATE_FORMAT.format(time));
            rankList = JSONObject.parseArray(rankString, Rank.class);
        } else {
            rankList = rankDAO.getSiteRanks(time);
            stringRedisTemplate.opsForValue().set(RANK_PREFIX + SIMPLE_DATE_FORMAT.format(time), JSONObject.toJSONString(rankList), 30, TimeUnit.MINUTES);
        }
        Collections.sort(rankList);
        if ("reverse".equals(order)) {
            Collections.reverse(rankList);
        }
        return rankList;
    }
}
