package com.marticles.airnet.exportservice.service;

import com.marticles.airnet.exportservice.model.Pollution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Marticles
 * @description DataService
 * @date 2019/3/25
 */
@FeignClient(value = "airnet-zuul-gateway", fallback = DataService.FallBackService.class)
public interface DataService {

    @GetMapping("/data/standard/{site}/pollution")
    List<Pollution> getPollution(@RequestHeader("Authorization") String jwtToken,
                                 @PathVariable(value = "site") String site,
                                 @RequestParam(value = "start") String start,
                                 @RequestParam(value = "end") String end);

    @Slf4j
    @Component
    class FallBackService implements DataService {
        @Override
        public List<Pollution> getPollution(String jwtToken, String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Data service was disable! getPollution(site=%s, start=%s, end=%s)", site, start, end));
            log.error("***********************************");
            return null;
        }
    }
}
