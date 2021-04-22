package com.lunx.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lunx
 * @version 1.0
 * @date 2020/04/20
 * @description 请求参数校验、权限校验、验签
 */
@Slf4j
@Component
public class SignCheckInterceptor implements AsyncHandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        if (request instanceof RequestWrapper) {
            System.out.println("拦截器:" + ((RequestWrapper) request).getRequestBodyStr());
        }

        RequestWrapper myRequestWrapper = new RequestWrapper(request);
        System.out.println("我是拦截器：" + myRequestWrapper.getRequestBodyStr());
        // do something
        return true;
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
