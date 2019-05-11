package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.constant.AirNetConstants;
import com.marticles.airnet.mainservice.model.ForecastList;
import com.marticles.airnet.mainservice.model.VizRequest;
import com.marticles.airnet.mainservice.service.DataService;
import com.marticles.airnet.mainservice.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ForecastController
 * @date 2019/3/25
 */
@Controller
@RequestMapping("/forecast")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private DataService dataService;

    @GetMapping("/cn")
    public String forecastCN(Model model){
        List<String> imgUrlList = forecastService.getCNImgList();
        List<String> day1ImgList = imgUrlList.subList(0,7);
        List<String> day2ImgList = imgUrlList.subList(8,15);
        List<String> day3ImgList = imgUrlList.subList(16,23);
        List<String> day4ImgList = imgUrlList.subList(24,31);
        List<String> day5ImgList = imgUrlList.subList(32,39);
        List<String> day6ImgList = imgUrlList.subList(40,47);
        List<String> day7ImgList = imgUrlList.subList(48,56);
        List<String> timeList = forecastService.getTime();
        model.addAttribute("day1ImgList",day1ImgList);
        model.addAttribute("day2ImgList",day2ImgList);
        model.addAttribute("day3ImgList",day3ImgList);
        model.addAttribute("day4ImgList",day4ImgList);
        model.addAttribute("day5ImgList",day5ImgList);
        model.addAttribute("day6ImgList",day6ImgList);
        model.addAttribute("day7ImgList",day7ImgList);
        model.addAttribute("timeList",timeList);
        return "/forecast/forecast_cn";
    }

    @GetMapping("/csj")
    public String forecastCSJ(Model model){
        List<String> imgUrlList = forecastService.getCSJImgList();
        List<String> day1ImgList = imgUrlList.subList(0,7);
        List<String> day2ImgList = imgUrlList.subList(8,15);
        List<String> day3ImgList = imgUrlList.subList(16,23);
        List<String> day4ImgList = imgUrlList.subList(24,31);
        List<String> day5ImgList = imgUrlList.subList(32,39);
        List<String> day6ImgList = imgUrlList.subList(40,47);
        List<String> day7ImgList = imgUrlList.subList(48,56);
        List<String> timeList = forecastService.getTime();
        model.addAttribute("day1ImgList",day1ImgList);
        model.addAttribute("day2ImgList",day2ImgList);
        model.addAttribute("day3ImgList",day3ImgList);
        model.addAttribute("day4ImgList",day4ImgList);
        model.addAttribute("day5ImgList",day5ImgList);
        model.addAttribute("day6ImgList",day6ImgList);
        model.addAttribute("day7ImgList",day7ImgList);
        model.addAttribute("timeList",timeList);
        return "/forecast/forecast_csj";
    }

    @GetMapping("/sh")
    public String forecastSH(Model model){
        return "/forecast/forecast_sh";
    }

    @GetMapping("/default")
    @ResponseBody
    public ForecastList getDefaultForecastData() throws Exception{
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, AirNetConstants.DEFAULT_SITE);
        Date startDate = null;
        if (null == siteUpdatedTime) {
            startDate = SIMPLE_DATE_FORMAT.parse(AirNetConstants.DEFAULT_UPDATEDTIME);
        } else {
            startDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_WEEK, 7);
        Date endDate = calendar.getTime();
        ForecastList forecastList = forecastService.getShForecast("forecast_yangpusipiao",SIMPLE_DATE_FORMAT.format(startDate),SIMPLE_DATE_FORMAT.format(endDate));
        return forecastList;
    }

    @PostMapping("/custom")
    @ResponseBody
    public ForecastList getCustomForecastData(@RequestBody VizRequest forecastRequest){
        ForecastList forecastList = forecastService.getShForecast(forecastRequest.getSite(),forecastRequest.getStart(),forecastRequest.getEnd());
        return forecastList;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
