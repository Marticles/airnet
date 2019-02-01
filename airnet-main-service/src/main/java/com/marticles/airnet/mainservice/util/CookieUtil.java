package com.marticles.airnet.mainservice.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Marticles
 * @description CookieUtil
 * @date 2019/2/2
 */
public class CookieUtil {

    public static String getCookie(HttpServletRequest request, String name){
        String cookieValue = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
