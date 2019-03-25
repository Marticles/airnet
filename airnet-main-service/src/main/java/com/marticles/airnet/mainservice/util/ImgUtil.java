package com.marticles.airnet.mainservice.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marticles
 * @description ImgUtil
 * @date 2019/3/25
 */
public class ImgUtil {

    private final static Pattern IMG_PATTERN = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");
    private final static Pattern URL_PATTERN = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");



    public static List<String> getImgUrl(RestTemplate restTemplate,String url) {
        String imgUrl = "";
        List<String> srcList = new ArrayList<>(16);
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
        return srcList;
    }
}
