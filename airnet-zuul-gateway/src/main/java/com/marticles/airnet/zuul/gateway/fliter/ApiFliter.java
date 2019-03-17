package com.marticles.airnet.zuul.gateway.fliter;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import com.marticles.airnet.zuul.gateway.model.ApiCount;
import com.marticles.airnet.zuul.gateway.model.ApiKey;
import com.marticles.airnet.zuul.gateway.service.ApiKeyService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ApiFliter extends ZuulFilter {

    private final String APISERVICE_URL = "/api";

    private final String APIKEY_PREFIX = "ApiKey-";

    private final String APICOUNT_PREFIX = "ApiCount-";

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
        log.info(request.getRequestURL().toString());
        if (null == apiKey || !checkApiKey(apiKey)) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody("Your key is illegal");
        } else {
            if (stringRedisTemplate.hasKey(APIKEY_PREFIX + apiKey)) {
                ApiKey apiKeyInfo = JSONObject.parseObject(stringRedisTemplate.opsForValue().get(APIKEY_PREFIX + apiKey), ApiKey.class);
                // 校验当月的累计请求次数
                if (stringRedisTemplate.hasKey(APICOUNT_PREFIX + apiKey)) {
                    ApiCount apiCount = JSONObject.parseObject(stringRedisTemplate.opsForValue().get(APICOUNT_PREFIX + apiKey), ApiCount.class);
                    if (apiCount.getMonthlyRequestCount() >= apiCount.getMonthlyRequestLimit()) {
                        requestContext.setSendZuulResponse(false);
                        requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                        requestContext.setResponseBody("The api requests limit of this month has been reached");
                    } else {
                        apiCount.setMonthlyRequestCount(apiCount.getMonthlyRequestCount() + 1);
                        stringRedisTemplate.opsForValue().set(APICOUNT_PREFIX + apiKey, JSONObject.toJSONString(apiCount));
                    }
                } else {
                    ApiCount apiCount = new ApiCount();
                    apiCount.setMonthlyRequestLimit(apiKeyInfo.getMonthlyRequestLimit());
                    apiCount.setMonthlyRequestCount(1);
                    stringRedisTemplate.opsForValue().set(APICOUNT_PREFIX + apiKey, JSONObject.toJSONString(apiCount));
                }
                RateLimiter limiter = null != rateLimiterMap.get(apiKey) ? rateLimiterMap.get(apiKey) : RateLimiter.create(apiKeyInfo.getPreSecondRequestLimit());
                // 1秒内被阻塞，直接返回429
                if (!limiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                    requestContext.setResponseBody("Too many requests");
                }
            } else {
                ApiKey apiKeyInfo = apiKeyService.getApiKey(apiKey);
                stringRedisTemplate.opsForValue().set(APIKEY_PREFIX + apiKey, JSONObject.toJSONString(apiKeyInfo));
                // 校验当月的累计请求次数
                if (stringRedisTemplate.hasKey(APICOUNT_PREFIX + apiKey)) {
                    ApiCount apiCount = JSONObject.parseObject(stringRedisTemplate.opsForValue().get(APICOUNT_PREFIX + apiKey), ApiCount.class);
                    if (apiCount.getMonthlyRequestCount() >= apiCount.getMonthlyRequestLimit()) {
                        requestContext.setSendZuulResponse(false);
                        requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                        requestContext.setResponseBody("The Api requests limit of this month has been reached");
                    } else {
                        apiCount.setMonthlyRequestCount(apiCount.getMonthlyRequestCount() + 1);
                        stringRedisTemplate.opsForValue().set(APICOUNT_PREFIX + apiKey, JSONObject.toJSONString(apiCount));
                    }
                } else {
                    ApiCount apiCount = new ApiCount();
                    apiCount.setMonthlyRequestLimit(apiKeyInfo.getMonthlyRequestLimit());
                    apiCount.setMonthlyRequestCount(1);
                    stringRedisTemplate.opsForValue().set(APICOUNT_PREFIX + apiKey, JSONObject.toJSONString(apiCount));

                }
                RateLimiter limiter = null != rateLimiterMap.get(apiKey) ? rateLimiterMap.get(apiKey) : RateLimiter.create(apiKeyInfo.getPreSecondRequestLimit());
                rateLimiterMap.put(apiKey, limiter);
                if (!limiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
                    requestContext.setResponseBody("Too many requests");
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
