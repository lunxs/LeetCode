package com.lunx.config;

import com.lunx.interceptor.SignCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


/**
 * @author lunx
 * @version 1.0
 * @date 2020/04/15
 * @description 此类实现了web mvc interceptor实现和编码设置，
 */
@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Resource
    private SignCheckInterceptor signCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/hystrix.stream", "/monitorWeb*", "/test", "/swagger*", "/v2/api-docs",
                        "/error", "/uploadFile");
//        super.addInterceptors(registry);
    }

    @Bean
    public CharacterEncodingFilter initializeCharacterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

}