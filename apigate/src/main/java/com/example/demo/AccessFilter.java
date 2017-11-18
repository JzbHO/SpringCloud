package com.example.demo;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/18 0018.
 */
public class AccessFilter extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();

        log.info("send {} request to {}",request.getMethod(),
                request.getRequestURI().toString());

        Object accessToken=request.getParameter("accessToken");
//
//        System.out.println(accessToken.toString());
        if(accessToken==null){
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }
      //  ctx.setSendZuulResponse(true);
        log.info("access token ok");
        return null;
    }
}
