package com.marticles.airnet.zuul.gateway.fliter;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import com.marticles.airnet.zuul.gateway.model.ApiKey;
import com.marticles.airnet.zuul.gateway.service.ApiKeyService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author Marticles
 * @description ApiFliter
 * @date 2019/3/13
 */
public class ApiFliter extends ZuulFilter {

    private final String APISERVICE_URL = "/api";

    private final String APIKEY_PREFIX = "ApiKey-";

    private final ConcurrentHashMap<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    ApiKeyService apiKeyService;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String url = request.getRequestURL().toString();
        if (url.contains(APISERVICE_URL)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String apiKey = request.getParameter("key");
        // TODO 一天内访问次数
        if (null == apiKey || !checkApiKey(apiKey)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody("Api key is empty");
        } else {
            if (stringRedisTemplate.hasKey(APIKEY_PREFIX + apiKey)) {
                ApiKey apiKeyInfo = JSONObject.parseObject(stringRedisTemplate.opsForValue().get(APIKEY_PREFIX + apiKey), ApiKey.class);
                // 查看当天的流量
                RateLimiter limiter = rateLimiterMap.get(apiKey);
                // 1秒内被阻塞，直接返回429
                if(!limiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                    requestContext.setResponseBody("Too Many Requests");
                }
            } else {
                ApiKey apiKeyInfo = apiKeyService.getApiKey(apiKey);
                stringRedisTemplate.opsForValue().set(APIKEY_PREFIX + apiKey, JSONObject.toJSONString(apiKeyInfo));
                // 查看当天的流量
                RateLimiter limiter = RateLimiter.create(apiKeyInfo.getPreSecondRequestLimit());
                rateLimiterMap.put(apiKey, limiter);
                if(!limiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                    requestContext.setResponseBody("Too Many Requests");
                }
            }
        }
        return null;
    }

    private boolean checkApiKey(String key) {
        if (stringRedisTemplate.hasKey(APIKEY_PREFIX + key)) {
            return true;
        } else {
            if (null != apiKeyService.getApiKey(key)) {
                return true;
            }
        }
        return false;
    }



}
