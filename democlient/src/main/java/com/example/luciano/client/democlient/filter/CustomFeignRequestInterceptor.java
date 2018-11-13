package com.example.luciano.client.democlient.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomFeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getDetails() instanceof Map) {
            Map<String, String> details = (Map<String, String>) authentication.getDetails();
            if (details.containsKey("access_token") && details.containsKey("type_token")) {
                requestTemplate.header("Authorization", details.get("type_token") + " " + details.get("access_token"));
            }
        }
    }
}
