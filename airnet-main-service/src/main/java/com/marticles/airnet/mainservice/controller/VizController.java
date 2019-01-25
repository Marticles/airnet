package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.service.VizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private static final String DEFAULT_SITE = "yangpusipiao";
    private static final String DEFAULT_POLLUTION = "pm25";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    UserLocal userLocal;

    @Autowired
    VizService vizService;

    @GetMapping("/line")
    public String line(Model model) throws Exception {
        JSONObject siteUpdatedTime = vizService.getSiteUpdatedTime(DEFAULT_SITE);

        Date endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK, -1);
        Date startDate = calendar.getTime();

        JSONObject pm25 = vizService.getPollution(DEFAULT_SITE,
                DEFAULT_POLLUTION,
                SIMPLE_DATE_FORMAT.format(startDate),
                SIMPLE_DATE_FORMAT.format(endDate));
        model.addAttribute("pm25",pm25);
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
