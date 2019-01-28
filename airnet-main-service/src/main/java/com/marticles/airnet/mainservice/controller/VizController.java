package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.model.VizRequest;
import com.marticles.airnet.mainservice.service.VizService;
import com.marticles.airnet.mainservice.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 默认视图返回最后一周的PM2.5数据
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
    UserLocal userLocal;

    @Autowired
    VizService vizService;

    @GetMapping("/default")
    @ResponseBody
    public JSONObject getDefaultVizData() throws Exception {
        JSONObject siteUpdatedTime = vizService.getSiteUpdatedTime(Global.DEFAULT_SITE);
        Date endDate = null;
        if (null == siteUpdatedTime){
            endDate = SIMPLE_DATE_FORMAT.parse(Global.DEFAULT_UPDATEDTIME);
        }else{
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        Date startDate = calendar.getTime();
        JSONObject data = vizService.getPollution(Global.DEFAULT_SITE,
                Global.DEFAULT_POLLUTION,
                SIMPLE_DATE_FORMAT.format(startDate),
                SIMPLE_DATE_FORMAT.format(endDate));
        return data;
    }

    @PostMapping("/custom")
    @ResponseBody
    public JSONObject getCustomVizData(@RequestBody VizRequest vizRequest) {
        return vizService.getAllPollution(vizRequest.getSite(), vizRequest.getStart(), vizRequest.getEnd());
    }

    @GetMapping("/line")
    public String line() {
        return "/viz/line";
    }

    @GetMapping("/test/{site}/pollution")
    @ResponseBody
    public JSONObject test(@PathVariable String site,
                           @RequestParam String start,
                           @RequestParam String end) {
        return vizService.getAllPollution(site, start, end);
    }


}
