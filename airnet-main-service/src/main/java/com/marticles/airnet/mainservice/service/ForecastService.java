package com.marticles.airnet.mainservice.service;

import com.marticles.airnet.mainservice.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ForecastService
 * @date 2019/3/25
 */
@Service
public class ForecastService {

    private static final String FORECAST_CN_URL = "http://carbon.nju.edu.cn/cn/china.php";

    private static final String FORECAST_CSJ_URL = "http://carbon.nju.edu.cn/cn/eastchina.php";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getCNImgList() {
        List<String> imgUrlList = ImgUtil.getImgUrl(restTemplate, FORECAST_CN_URL);
        imgUrlList.remove(0);
        return imgUrlList;
    }

    public List<String> getCSJImgList() {
        List<String> imgUrlList = ImgUtil.getImgUrl(restTemplate, FORECAST_CSJ_URL);
        imgUrlList.remove(0);
        return imgUrlList;
    }

    public List<String> getTime() {
        List<String> timeList = new ArrayList<>(7);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        for (int i = 1; i <= 7; i++) {
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            timeList.add(SIMPLE_DATE_FORMAT.format(calendar.getTime()));
        }
        return timeList;
    }
}
