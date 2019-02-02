package com.marticles.airnet.zuul.gateway.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Slf4j
public class TestFliter extends ZuulFilter {

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
        String authToken = "";
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains(dataServiceURL)) {
            authToken = request.getHeader("Authorization");
            System.out.println(requestUrl);
            System.out.println("Token:"+authToken);
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
