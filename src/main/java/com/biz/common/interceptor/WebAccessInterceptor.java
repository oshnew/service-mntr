package com.biz.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebAccessInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WebAccessInterceptor.class);

    /**
     * 컨트롤러 호출 전에 실행되는 핸들러
     * 
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws NotAuthToolAccessException
     * @throws ModelAndViewDefiningException 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 컨트롤러 종료 후 타는 인터셉터 메소드
     * 
     * @param request   
     * @param response
     * @param handler
     * @return
     * @throws Exception 
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
}
