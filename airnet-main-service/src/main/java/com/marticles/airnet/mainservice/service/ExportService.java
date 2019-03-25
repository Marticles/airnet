package com.marticles.airnet.mainservice.service;

import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Marticles
 * @description ExportService
 * @date 2019/3/25
 */
@FeignClient(value = "airnet-zuul-gateway", fallback = ExportService.FallBackService.class)
public interface ExportService {

    @GetMapping("/export/excel/{site}")
    Response exportExcel(@RequestHeader("Authorization") String jwtToken,
                         @PathVariable(value = "site") String site,
                         @RequestParam(value = "start") String start,
                         @RequestParam(value = "end") String end);

    @Slf4j
    @Component
    class FallBackService implements ExportService {
        @Override
        public Response exportExcel(String jwtToken, String site, String start, String end) {
            log.error("***********************************");
            log.error(String.format("Export service was disable! exportExcel(site=%s, start=%s, end=%s)", site, start, end));
            log.error("***********************************");
            return null;
        }
    }
}
