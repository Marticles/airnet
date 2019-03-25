package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.constant.AirNetConstants;
import com.marticles.airnet.mainservice.service.DataService;
import com.marticles.airnet.mainservice.service.ExportService;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Marticles
 * @description ExportController
 * @date 2019/3/23
 */
@Slf4j
@RequestMapping("/export")
@Controller
public class ExportController {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ExportService exportService;

    @Autowired
    private DataService dataService;

    @GetMapping("")
    public String export(Model model) {
        return "/export";
    }


    @ResponseBody
    @GetMapping("/default")
    public JSONObject getDefaultExportData(@RequestHeader(value = "Authorization") String jwtToken) throws Exception {
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
        jsonObject.put("start", SIMPLE_DATE_FORMAT.format(startDate));
        jsonObject.put("end", SIMPLE_DATE_FORMAT.format(endDate));
        jsonObject.put("site", "jingan");
        jsonObject.put("pollutant", dataService.getAllPollutionForPage(jwtToken, "yangpusipiao", SIMPLE_DATE_FORMAT.format(startDate), SIMPLE_DATE_FORMAT.format(endDate), 1, 10));
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


    /**
     * Feign调用Export微服务完成excel导出
     *
     * @param jwtToken
     * @param site
     * @param start
     * @param end
     * @return org.springframework.http.ResponseEntity<byte   [   ]>
     * @author Marticles
     * @date 2019/3/25
     */
    @GetMapping("/excel/{site}")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcel(@PathVariable String site,
                                              @RequestParam String start,
                                              @RequestParam String end,
                                              @RequestParam String jwt) {
        ResponseEntity<byte[]> result = null;
        Response feignResponse = exportService.exportExcel(jwt, site, start, end);
        Response.Body body = feignResponse.body();
        try (InputStream inputStream = body.asInputStream()) {
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            HttpHeaders heads = new HttpHeaders();
            String fileName = site + "-" + start + "-" + end + ".xls";
            heads.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
            heads.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            result = new ResponseEntity<>(b, heads, HttpStatus.OK);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return result;
    }

}
