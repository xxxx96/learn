package com.Interceptor;

import com.annotation.NeedLogin;
import com.entity.Admin;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.Validator;

public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    private final static Logger LOGGER = LoggerFactory.getLogger(CheckLoginInterceptor.class);

    /**
     * 配置登录页面url,如果没登录且没有配置自定义的跳转，那么跳到这里
     */
    public static final String LOGIN_PAGE_URL = "login";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            //获取方法上有没有打注解
            NeedLogin needLogin = method.getMethodAnnotation(NeedLogin.class);
            // 不为null表示该方法打了注解需要校验是否登录了
            if (needLogin != null) {
                //获取请求参数
                String query = StringUtils.isNotEmpty(request.getQueryString()) ? ("?" + request.getQueryString()) : "";
                // 先获取当前请求的请求完整url
                String callBackUrl = request.getRequestURL().toString() + query;
                //判断是否登录了
                Admin admin = (Admin) request.getSession().getAttribute("admin");
                if (admin != null) {

                    return true;
                } else {
                    // 如果没有登录
                    // 校验是否配置了自定义的跳转地址

                    if (StringUtils.isNotEmpty(needLogin.returnUrl())) {

                        // 自定义的跳转地址不为null那么去做重定向跳转
                        response.sendRedirect(needLogin.returnUrl());
                    } else {
                        // 没有配置自定义的跳转,根据我们的业务应该会跳到登录页面

                        String finallyUrl = LOGIN_PAGE_URL ;

                        // 开始做重定向操作
                       response.sendRedirect(finallyUrl);
                       return false;
                    }

                    }

                }
            }
            return true;
        }
    }
