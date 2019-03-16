package com.marticles.airnet.apiservice.service;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 由DataService微服务提供数据
 *
 * @author Marticles
 * @description DataService
 * @date 2019/1/25
 */
@FeignClient(value = "airnet-zuul-gateway",fallback = DataService.VizFallBackService.class)
public interface DataService {

    @GetMapping("/data/standard/{site}/pollution")
    JSONArray getAllPollution(@RequestHeader("Authorization") String jwtToken,
                               @PathVariable(value = "site") String site,
                               @RequestParam(value = "start") String start,
                               @RequestParam(value = "end") String end);

    @GetMapping("/data/standard/{site}/{pollution}")
    JSONArray getPollution(@RequestHeader("Authorization") String jwtToken,
                            @PathVariable(value = "site") String site,
                            @PathVariable(value = "pollution") String pollution,
                            @RequestParam(value = "start") String start,
                            @RequestParam(value = "end") String end);


    @GetMapping("/data/{site}/updated-time")
    JSONArray getSiteUpdatedTime(@RequestHeader("Authorization") String jwtToken,
                                  @PathVariable(value = "site") String site);


    @GetMapping("/data/rank")
    JSONArray getSiteRanks(@RequestHeader("Authorization") String jwtToken,
                           @RequestParam(value = "time") String time,
                           @RequestParam(value = "order") String order);

    @Slf4j
    @Component
    class VizFallBackService implements DataService {


        @Override
        public JSONArray getAllPollution(String jwtToken, String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getAllPollution(site=%s, start=%s, end=%s)", site, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONArray getPollution(String jwtToken, String site, String pollution, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getPollution(site=%s, pollution=%s, start=%s, end=%s)", site, pollution, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONArray getSiteUpdatedTime(String jwtToken, String site) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteUpdatedTime(site=%s)", site));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONArray getSiteRanks(String jwtToken, String time, String order) {
            return null;
        }
    }
}
