package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.CityRank;
import com.marticles.airnet.mainservice.model.RankRequest;
import com.marticles.airnet.mainservice.model.SiteRank;
import com.marticles.airnet.mainservice.service.DataService;
import com.marticles.airnet.mainservice.service.IndexService;
import com.marticles.airnet.mainservice.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 空气质量排行
 * 基于Redis中的zset实现
 *
 * @author Marticles
 * @description RankController
 * @date 2019/2/6
 */
@Controller
@RequestMapping("/rank")
public class RankController {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    RankService rankService;

    @Autowired
    DataService dataService;

    @Autowired
    IndexService indexService;

    @PostMapping("")
    @ResponseBody
    public List<SiteRank> rank(@RequestHeader(value = "Authorization") String jwtToken,
                           @RequestBody RankRequest rankRequest) {
        List<SiteRank> siteRankList = dataService.getSiteRanks(jwtToken,rankRequest.getTime(),rankRequest.getOrder());
        return siteRankList;
    }

    @GetMapping("/sh")
    public String shRank(Model model) {
        model.addAttribute("updatedTime",indexService.getIndexUpdatedTime());
        return "/rank/sh";
    }

    @GetMapping("/cn")
    public String cnRank(Model model) {
        List<CityRank> cityRanks = rankService.getCNRank(false);
        List<CityRank> reverseCityRanks = rankService.getCNRank(true);
        model.addAttribute("cityRanks", cityRanks);
        model.addAttribute("reverseCityRanks", reverseCityRanks);
        Date updatedTime = setUpdatedTime(reverseCityRanks.get(0).getTime());
        model.addAttribute("updatedTime", SIMPLE_DATE_FORMAT.format(updatedTime));
        return "/rank/cn";
    }

    private Date setUpdatedTime(Date updatedTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updatedTime);
        calendar.add(Calendar.HOUR, -8);
        return calendar.getTime();
    }

}
