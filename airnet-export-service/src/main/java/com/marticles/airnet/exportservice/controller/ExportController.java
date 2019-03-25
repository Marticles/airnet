package com.marticles.airnet.exportservice.controller;

import com.marticles.airnet.exportservice.model.Pollution;
import com.marticles.airnet.exportservice.service.DataService;
import com.marticles.airnet.exportservice.util.ExcelUtil;
import constant.AirNetConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Marticles
 * @description ExportController
 * @date 2019/3/25
 */
@Slf4j
@Controller
public class ExportController {

    @Autowired
    private DataService dataService;


    @GetMapping("/excel/{site}")
    @ResponseBody
    public void export(@PathVariable String site,
                       @RequestParam String start,
                       @RequestParam String end,
                       HttpServletResponse response) {
        List<Pollution> pollutionList = dataService.getPollution(AirNetConstants.VISITOR_JWT, site, start, end);
        String fileName = site + "-" + start.replace(" ", "-").replace(":", "-") + "-" + end.replace(" ", "-").replace(":", "-") + ".xls";
        ExcelUtil.exportExcel(pollutionList, "AirNet历史污染物数据导出", "AirNet", Pollution.class, fileName, response);
    }

}
