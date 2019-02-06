package com.marticles.airnet.mainservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marticles
 * @description MapService
 * @date 2019/2/6
 */
@Service
public class MapService {

    private final static Pattern IMG_PATTERN = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");
    private final static Pattern URL_PATTERN = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过正则提取全国AQI地图URL
     *
     * @param
     * @return java.lang.String
     * @author Marticles
     * @date 2019/2/6
     */
    public String getAqiMap() {
        String url = "http://www.air-level.com";
        String imgUrl = "";
        List<String> srcList = new ArrayList<>();
        ResponseEntity<String> responseEntityEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntityEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
            String content = responseEntityEntity.getBody();
            Matcher imgMatcher = IMG_PATTERN.matcher(content);
            boolean isImg = imgMatcher.find();
            if (isImg == true) {
                while (isImg) {
                    String group = imgMatcher.group(2);
                    Matcher urlMatcher = URL_PATTERN.matcher(group);
                    if (urlMatcher.find()) {
                        srcList.add(urlMatcher.group(3));
                    }
                    isImg = imgMatcher.find();
                }
            }
        }
        for (String src : srcList) {
            if(!src.contains("logo")){
                imgUrl = src;
            }
        }
        imgUrl = imgUrl.substring(0,imgUrl.length());
        return imgUrl;
    }
}
