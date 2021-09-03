package com.lunx.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author desong.xie
 * @version 1.0
 * @date 2020/06/09
 * @description
 */
//@Configuration
public class RestTemplateConfig {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(5 * 1000);
        httpRequestFactory.setConnectTimeout(5 * 1000);
        httpRequestFactory.setReadTimeout(5 * 1000);

        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.setErrorHandler(new NoOpResponseErrorHandler());
        return restTemplate;
    }

    private static class NoOpResponseErrorHandler extends DefaultResponseErrorHandler {
        private NoOpResponseErrorHandler() {
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
        }
    }
}
