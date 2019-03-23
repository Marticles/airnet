package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marticles
 * @description ExportController
 * @date 2019/3/23
 */
@RequestMapping("/export")
@Controller
public class ExportController {

    @Autowired
    private DataService dataService;

    @GetMapping("")
    public String export(Model model) {
        return "/export";
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
