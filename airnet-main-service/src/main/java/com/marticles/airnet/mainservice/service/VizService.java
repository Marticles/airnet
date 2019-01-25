package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Marticles
 * @description VizService
 * @date 2019/1/25
 */
@FeignClient(value = "airnet-zuul-gateway")
public interface VizService {

    @GetMapping("/data/{site}/pollution")
    JSONObject getAllPollution(@PathVariable(value = "site") String site,
                               @RequestParam(value = "start") String start,
                               @RequestParam(value = "end") String end);

    @GetMapping("/data/{site}/{pollution}")
    JSONObject getPollution(@PathVariable(value = "site") String site,
                                               @PathVariable(value = "pollution") String pollution,
                                               @RequestParam(value = "start") String start,
                                               @RequestParam(value = "end") String end);
    @GetMapping("/data/{site}/updated-time")
    JSONObject getSiteUpdatedTime(@PathVariable(value = "site") String site);


    @Slf4j
    @Component
    class VizFallBackService implements VizService {
        @Override
        public JSONObject getAllPollution(String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getAllPollution(%s, %s, %s)", site, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getPollution(String site, String pollution, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getPollution(%s, %s, %s, %s)", site, pollution, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getSiteUpdatedTime(String site) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteUpdatedTime(%s)", site));
            log.error("***********************************");
            return null;
        }
    }
}
