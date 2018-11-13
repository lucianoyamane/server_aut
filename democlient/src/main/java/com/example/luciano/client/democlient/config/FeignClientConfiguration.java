package com.example.luciano.client.democlient.config;

import com.example.luciano.client.democlient.filter.CustomFeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {
    @Bean
    public RequestInterceptor bearerHeaderAuthRequestInterceptor() {
        return new CustomFeignRequestInterceptor();
    }
}
