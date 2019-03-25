package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.constant.AirNetConstants;
import com.marticles.airnet.mainservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Marticles
 * @description ExportController
 * @date 2019/3/23
 */
@RequestMapping("/export")
@Controller
public class ExportController {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Autowired
    private DataService dataService;

    @GetMapping("")
    public String export(Model model) {
        return "/export";
    }


    @ResponseBody
    @GetMapping("/default")
    public JSONObject getDefaultExportData(@RequestHeader(value = "Authorization") String jwtToken) throws Exception{
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
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("start",SIMPLE_DATE_FORMAT.format(startDate));
        jsonObject.put("end",SIMPLE_DATE_FORMAT.format(endDate));
        jsonObject.put("site","jingan");
        jsonObject.put("pollutant",dataService.getAllPollutionForPage(jwtToken, "yangpusipiao", SIMPLE_DATE_FORMAT.format(startDate), SIMPLE_DATE_FORMAT.format(endDate), 1, 10));
        return jsonObject;
    }

    /**
     * 返回分页后的污染物数据
     *
     * @param jwtToken
     * @param site
     * @param start
     * @param end
     * @param pageNum
     * @param pageSize
     * @return com.alibaba.fastjson.JSONObject
     * @author Marticles
     * @date 2019/3/23
     */
    @ResponseBody
    @GetMapping("/{site}/pollution")
    public JSONObject getAllPollutionForPage(@RequestHeader(value = "Authorization") String jwtToken,
                                             @PathVariable String site,
                                             @RequestParam String start,
                                             @RequestParam String end,
                                             @RequestParam Integer pageNum,
                                             @RequestParam Integer pageSize) {
        return dataService.getAllPollutionForPage(jwtToken, site, start, end, pageNum, pageSize);
    }

}
