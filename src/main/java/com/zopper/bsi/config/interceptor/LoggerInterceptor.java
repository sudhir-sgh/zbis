package com.zopper.bsi.config.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by sudhir on 23/5/16.
 */
public class LoggerInterceptor implements HandlerInterceptor {

    Logger logger  = Logger.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("PRE handle request processing..");

        logHeaders(httpServletRequest);
        logParameters(httpServletRequest);

        return true;
    }

    private void logParameters(HttpServletRequest httpServletRequest) {
        Enumeration params = httpServletRequest.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            logger.info("Parameter Name - "+paramName+", Value - "+httpServletRequest.getParameter(paramName));
        }
    }

    private void logHeaders(HttpServletRequest httpServletRequest) {
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            logger.info("Header Name - " + headerName + ", Value - " + httpServletRequest.getHeader(headerName));
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("POST handle request processing..");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("AFTER COMPLETION handle request processing..");
    }
}
