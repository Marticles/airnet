package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.Notification;
import com.marticles.airnet.mainservice.model.SiteRank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/data/{site}/pollution")
    JSONObject getAllPollution(@RequestHeader("Authorization") String jwtToken,
                               @PathVariable(value = "site") String site,
                               @RequestParam(value = "start") String start,
                               @RequestParam(value = "end") String end);

    @GetMapping("/data/{site}/{pollution}")
    JSONObject getPollution(@RequestHeader("Authorization") String jwtToken,
                                @PathVariable(value = "site") String site,
                                @PathVariable(value = "pollution") String pollution,
                                @RequestParam(value = "start") String start,
                                @RequestParam(value = "end") String end);


    @GetMapping("/data/{site}/updated-time")
    JSONObject getSiteUpdatedTime(@RequestHeader("Authorization") String jwtToken,
                                  @PathVariable(value = "site") String site);


    @GetMapping("/data/rank")
    List<SiteRank> getSiteRanks(@RequestHeader("Authorization") String jwtToken,
                            @RequestParam(value = "time") String time,
                            @RequestParam(value = "order") String order);

    @GetMapping("/data/notification/{userId}")
    List<Notification> getNotifications(@RequestHeader(value = "Authorization") String jwtToken,
                                       @PathVariable(value = "userId") Integer userId,
                                       @RequestParam(value = "read-status") Integer readStatus);

    @PutMapping("data/notification/{id}")
    void readNotification(@RequestHeader(value = "Authorization") String jwtToken,
                          @PathVariable(value = "id") Integer id);


    @Slf4j
    @Component
    class VizFallBackService implements DataService {
        @Override
        public JSONObject getAllPollution(String jwtToken, String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getAllPollution(site=%s, start=%s, end=%s)", site, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getPollution(String jwtToken, String site, String pollution, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getPollution(site=%s, pollution=%s, start=%s, end=%s)", site, pollution, start, end));
            log.error("***********************************");
            return null;
        }

        @Override
        public JSONObject getSiteUpdatedTime(String jwtToken, String site) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteUpdatedTime(site=%s)", site));
            log.error("***********************************");
            return null;
        }

        @Override
        public List<SiteRank> getSiteRanks(String jwtToken, String time, String order) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getSiteRanks(time=%s, order=%s)", time, order));
            log.error("***********************************");
            return null;
        }

        @Override
        public List<Notification> getNotifications(String jwtToken, Integer userId, Integer readStatus) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getNotifications(userId=%s, readStatus=%s)", userId, readStatus));
            log.error("***********************************");
            return null;
        }

        @Override
        public void readNotification(String jwtToken, Integer id) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! readNotification(id=%s)", id));
            log.error("***********************************");
        }
    }
}
