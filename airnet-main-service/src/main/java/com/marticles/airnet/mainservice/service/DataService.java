package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.SiteRank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 由DataService微服务提供数据
 *
 * @author Marticles
 * @description DataService
 * @date 2019/1/25
 */
@FeignClient(value = "airnet-zuul-gateway",fallback = DataService.VizFallBackService.class)
public interface DataService {

    /**
     * @param jwtToken
     * @param site
     * @param start
     * @param end
     * @return com.alibaba.fastjson.JSONObject
     * @author Marticles
     * @date 2019/2/2
     */
    @GetMapping("/data/{site}/pollution")
    JSONObject getAllPollution(@RequestHeader("Authorization") String jwtToken,
                               @PathVariable(value = "site") String site,
                               @RequestParam(value = "start") String start,
                               @RequestParam(value = "end") String end);

    /**
     * @param jwtToken
     * @param site
     * @param pollution
     * @param start
     * @param end
     * @return com.alibaba.fastjson.JSONObject
     * @author Marticles
     * @date 2019/2/2
     */
    @GetMapping("/data/{site}/{pollution}")
    JSONObject getPollution(@RequestHeader("Authorization") String jwtToken,
                                @PathVariable(value = "site") String site,
                                @PathVariable(value = "pollution") String pollution,
                                @RequestParam(value = "start") String start,
                                @RequestParam(value = "end") String end);

    /**
     * @param jwtToken
     * @param site
     * @return com.alibaba.fastjson.JSONObject
     * @author Marticles
     * @date 2019/2/2
     */
    @GetMapping("/data/{site}/updated-time")
    JSONObject getSiteUpdatedTime(@RequestHeader("Authorization") String jwtToken,
                                  @PathVariable(value = "site") String site);


    @GetMapping("/data/rank")
    List<SiteRank> getSiteRanks(@RequestHeader("Authorization") String jwtToken,
                            @RequestParam(value = "time") String time,
                            @RequestParam(value = "order") String order);


    @Slf4j
    @Component
    class VizFallBackService implements DataService {
        @Override
        public JSONObject getAllPollution(String jwtToken, String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getAllPollution(%s, %s, %s)", site, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getPollution(String jwtToken, String site, String pollution, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getPollution(%s, %s, %s, %s)", site, pollution, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getSiteUpdatedTime(String jwtToken, String site) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteUpdatedTime(%s)", site));
            log.error("***********************************");
            return null;
        }

        @Override
        public List<SiteRank> getSiteRanks(String jwtToken, String time, String order) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteRanks(%s, %s)", time, order));
            log.error("***********************************");
            return null;
        }
    }
}
