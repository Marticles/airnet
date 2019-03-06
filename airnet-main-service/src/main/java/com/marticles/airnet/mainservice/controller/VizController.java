package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.constant.AirNetConstants;
import com.marticles.airnet.mainservice.model.VizRequest;
import com.marticles.airnet.mainservice.service.IndexService;
import com.marticles.airnet.mainservice.service.MapService;
import com.marticles.airnet.mainservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 可视化图表默认返回最新一周的PM2.5数据
 *
 * @author Marticles
 * @description VizController
 * @date 2019/1/23
 */
@Controller
@RequestMapping("/viz")
public class VizController {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DataService dataService;

    @Autowired
    private MapService mapService;

    @Autowired
    private IndexService indexService;

    @GetMapping("/default")
    @ResponseBody
    public JSONObject getDefaultVizData(@RequestHeader(value = "Authorization") String jwtToken) throws Exception {
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(jwtToken, AirNetConstants.DEFAULT_SITE);
        Date endDate = null;
        if (null == siteUpdatedTime) {
            endDate = SIMPLE_DATE_FORMAT.parse(AirNetConstants.DEFAULT_UPDATEDTIME);
        } else {
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        Date startDate = calendar.getTime();
        JSONObject data = dataService.getPollution(jwtToken, AirNetConstants.DEFAULT_SITE,
                AirNetConstants.DEFAULT_POLLUTION,
                SIMPLE_DATE_FORMAT.format(startDate),
                SIMPLE_DATE_FORMAT.format(endDate));
        return data;
    }

    @PostMapping("/custom")
    @ResponseBody
    public JSONObject getCustomVizData(@RequestHeader(value = "Authorization") String jwtToken,
                                       @RequestBody VizRequest vizRequest) {
        return dataService.getAllPollution(jwtToken, vizRequest.getSite(), vizRequest.getStart(), vizRequest.getEnd());
    }

    @GetMapping("/line")
    public String line() {
        return "/viz/line";
    }

    @GetMapping("/bar")
    public String bar() {
        return "/viz/bar";
    }

    @GetMapping("/scatter")
    public String scatter() {
        return "/viz/scatter";
    }

    @GetMapping("/pie")
    public String pie() {
        return "/viz/pie";
    }

    @GetMapping("/radar")
    public String radar() {
        return "/viz/radar";
    }

    @GetMapping("/funnel")
    public String funnel() {
        return "/viz/funnel";
    }

    @GetMapping("/rose")
    public String rose() {
        return "/viz/rose";
    }

    @GetMapping("/airflowmap")
    public String airflowMap() {
        return "/viz/airflowmap";
    }

    @GetMapping("/aqimap")
    public String aqiMap(Model model) {
        model.addAttribute("updatedTime",indexService.getIndexUpdatedTime());
        model.addAttribute("imgURL",mapService.getAqiMap());
        return "/viz/aqimap";
    }

    @GetMapping("/globalmap")
    public String globalMap() {
        return "/viz/globalmap";
    }

}
