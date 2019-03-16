package com.marticles.airnet.apiservice.controller;

import com.marticles.airnet.apiservice.constant.AirNetConstants;
import com.marticles.airnet.apiservice.model.Info;
import com.marticles.airnet.apiservice.model.Response;
import com.marticles.airnet.apiservice.service.DataService;
import com.marticles.airnet.apiservice.service.OtherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marticles
 * @description ApiController
 * @date 2019/3/12
 */
@Slf4j
@RestController
@RequestMapping("/v1")
public class ApiController {

    @Autowired
    private DataService dataService;

    @Autowired
    private OtherService otherService;


    @GetMapping("/rank")
    public Response getRanks(@RequestParam("area") String area,
                             @RequestParam("time") String time,
                             @RequestParam("order") String order) {
        Response response = new Response();
        try {
            if ("sh".equals(area)) {
                response = successResponse(response);
                response.setData(new Info("air quality rank", dataService.getSiteRanks(AirNetConstants.VISITOR_JWT, time, order)));
            } else if ("cn".equals(area)) {
                response = successResponse(response);
                response.setData(new Info("air quality rank", otherService.getCNRank(order)));
            } else {
                response = failResponse(response, "area is illegal");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            response = failResponse(response, e.getMessage());
        }
        return response;
    }


    @GetMapping("/history")
    public Response getHistoryPollutant(@RequestParam("site") String site,
                                        @RequestParam("pollutant") String pollutant,
                                        @RequestParam("start") String start,
                                        @RequestParam("end") String end) {
        Response response = new Response();
        try {
            if ("all".equals(pollutant)) {
                response = successResponse(response);
                response.setData(new Info("all pollutant", dataService.getAllPollution(AirNetConstants.VISITOR_JWT, site, start, end)));
            } else {
                response = successResponse(response);
                response.setData(new Info(pollutant, dataService.getPollution(AirNetConstants.VISITOR_JWT, pollutant, site, start, end)));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            response = failResponse(response, e.getMessage());
        }
        return response;
    }

    // TODO
    @GetMapping("/forecast")
    public Response getPm25Forcast(@RequestParam("site") String site,
                                        @RequestParam("start") String start,
                                        @RequestParam("end") String end) {
        Response response = new Response();
        return  response;
    }

    private Response successResponse(Response response) {
        response.setCode(0);
        response.setMsg("success");
        return response;
    }

    private Response failResponse(Response response, String msg) {
        response.setCode(1);
        response.setMsg(msg);
        return response;
    }
}
