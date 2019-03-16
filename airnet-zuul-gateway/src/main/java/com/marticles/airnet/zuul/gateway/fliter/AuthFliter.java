package com.marticles.airnet.zuul.gateway.fliter;

import com.google.common.util.concurrent.RateLimiter;
import com.marticles.airnet.zuul.gateway.model.User;
import com.marticles.airnet.zuul.gateway.model.UserType;
import com.marticles.airnet.zuul.gateway.util.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限校验与限流
 *
 * @author Marticles
 * @description AuthFliter
 * @date 2019/2/1
 */
@Slf4j
public class AuthFliter extends ZuulFilter {



    private final String DATASERVICE_URL = "/data";

    private final String APIKEY_PREFIX = "ApiKey-";

    private final ConcurrentHashMap<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains(DATASERVICE_URL)) {
            // log.info(requestUrl);
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String authToken = request.getHeader("Authorization");
        log.info(request.getRequestURL().toString());
        if (null == authToken) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody("Authorization token is empty");
        } else {
            User user = JwtUtil.getUserInfoByJwt(authToken);
            if (null == user || user.getType().equals(UserType.USER_VISITOR)) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setResponseBody("Unauthorized Token");
            }
        }
        return null;
    }
}

