package com.marticles.airnet.mainservice.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.CityRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Marticles
 * @description RankService
 * @date 2019/2/6
 */
@Service
public class RankService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String CNRank_PREFIX = "CNRank-";
    private final String ReCNRank_PREFIX = "ReCNRank-";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<CityRank> getCNRank(boolean isReverse) throws Exception {
        Date now = new Date();
        List<CityRank> cityRanks = new ArrayList<>(256);
        List<CityRank> reverseCityRanks = new ArrayList<>(256);
        if (isReverse) {
            Set<String> ReRankSet = stringRedisTemplate.keys(ReCNRank_PREFIX+"*");
            // 逆序缓存中不存在
            if (0 == ReRankSet.size()) {
                String rankBody = getRankList();
                cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
                reverseCityRanks = cityRanks.subList(cityRanks.size() - 10, cityRanks.size());
                // cityRanks = cityRanks.subList(0, 10);
                Collections.reverse(reverseCityRanks);
                Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>(10);
                for (CityRank cityRank : reverseCityRanks) {
                    tuples.add(new DefaultTypedTuple<>(JSONObject.toJSONString(cityRank), Double.valueOf(cityRank.getAqi().toString())));
                }
                stringRedisTemplate.opsForZSet().add(ReCNRank_PREFIX + SIMPLE_DATE_FORMAT.format(now), tuples);

                // 逆序缓存中存在
            } else {
                String key = ReRankSet.iterator().next();
                // 先判断缓存数据是否超过一小时
                Date keyDate = SIMPLE_DATE_FORMAT.parse(key.substring(9, key.length()));
                if (now.getTime() - keyDate.getTime() > 60 * 60 * 1000) {
                    // 删除zset缓存
                    stringRedisTemplate.delete(key);
                    String rankBody = getRankList();
                    cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
                    reverseCityRanks = cityRanks.subList(cityRanks.size() - 10, cityRanks.size());
                    Collections.reverse(reverseCityRanks);
                    Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>(10);
                    for (CityRank cityRank : reverseCityRanks) {
                        tuples.add(new DefaultTypedTuple<>(JSONObject.toJSONString(cityRank), Double.valueOf(cityRank.getAqi().toString())));
                    }
                    stringRedisTemplate.opsForZSet().add(ReCNRank_PREFIX + SIMPLE_DATE_FORMAT.format(now), tuples);
                // 未超过一小时
                }else{
                    LinkedHashSet<String> ReRankSet2 = (LinkedHashSet<String>) stringRedisTemplate.opsForZSet().reverseRange(key, 0, 9);
                    for (String s : ReRankSet2) {
                        reverseCityRanks.add(JSONObject.parseObject(s, CityRank.class));
                    }
                }
            }
            return reverseCityRanks;
        } else {
            Set<String> RankSet = stringRedisTemplate.keys(CNRank_PREFIX+"*");
            // 顺序缓存中不存在
            if (0 == RankSet.size()) {
                String rankBody = getRankList();
                cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
                cityRanks = cityRanks.subList(0, 10);
                Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>(10);
                for (CityRank cityRank : cityRanks) {
                    tuples.add(new DefaultTypedTuple<>(JSONObject.toJSONString(cityRank), Double.valueOf(cityRank.getAqi().toString())));
                }
                stringRedisTemplate.opsForZSet().add(CNRank_PREFIX + SIMPLE_DATE_FORMAT.format(now), tuples);

                // 顺序缓存中存在
            } else {
                String key = RankSet.iterator().next();
                // 先判断缓存数据是否超过一小时
                Date keyDate = SIMPLE_DATE_FORMAT.parse(key.substring(7, key.length()));
                if (now.getTime() - keyDate.getTime() > 60 * 60 * 1000) {
                    stringRedisTemplate.delete(key);
                    String rankBody = getRankList();
                    cityRanks = JSONArray.parseArray(rankBody.substring(0, rankBody.length() - 1), CityRank.class);
                    cityRanks = cityRanks.subList(0, 10);
                    Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>(10);
                    for (CityRank cityRank : cityRanks) {
                        tuples.add(new DefaultTypedTuple<>(JSONObject.toJSONString(cityRank), Double.valueOf(cityRank.getAqi().toString())));
                    }
                    stringRedisTemplate.opsForZSet().add(CNRank_PREFIX + SIMPLE_DATE_FORMAT.format(now), tuples);

                }else{
                    LinkedHashSet<String> RankSet2 = (LinkedHashSet<String>) stringRedisTemplate.opsForZSet().reverseRange(key, 0, 9);
                    for (String s : RankSet2) {
                        cityRanks.add(JSONObject.parseObject(s, CityRank.class));
                    }
                }
            }
            return cityRanks;
        }

    }

    private String getRankList() {
        String url = "http://weather.gtimg.cn/aqi/cityrank.json";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
            String rankBody = responseEntity.getBody().replace("cityrank(", "");
            return rankBody;
        } else {
            return null;
        }

    }

}
