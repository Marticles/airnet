package com.marticles.airnet.zuul.gateway.fliter;

import com.marticles.airnet.zuul.gateway.Util.JwtUtil;
import com.marticles.airnet.zuul.gateway.model.User;
import com.marticles.airnet.zuul.gateway.model.UserType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 权限校验
 * 防止没有权限的用户直接访问内部微服务API
 *
 * @author Marticles
 * @description AuthFliter
 * @date 2019/2/1
 */
@Slf4j
public class AuthFliter extends ZuulFilter {

    private final String dataServiceURL = "/data";


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
        if (requestUrl.contains(dataServiceURL)) {
            System.out.println(requestUrl);
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String authToken = request.getHeader("Authorization");
        if (null == authToken) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            requestContext.setResponseBody("Token error");
        } else {
            User user = JwtUtil.getUserInfoByJwt(authToken);
            if (null == user || user.getType().equals(UserType.USER_COMMON)) {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setResponseBody("Unauthorized Token");
            }
        }
        return null;
    }
}
