package com.marticles.airnet.dataservice.controller;

import com.marticles.airnet.dataservice.model.Rank;
import com.marticles.airnet.dataservice.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description RankController
 * @date 2019/2/7
 */
@RestController
public class RankController {

    @Autowired
    RankService rankService;

    @GetMapping("/rank")
    public List<Rank> getSiteRanks(@RequestParam Date time,
                                   @RequestParam String order) {
        return rankService.getSiteRanks(time,order);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
