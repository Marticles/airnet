package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
