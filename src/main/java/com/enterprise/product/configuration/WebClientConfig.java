package com.enterprise.product.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${mocks.api.url}")
    private String mocksApiUrl;

    @Bean
    public WebClient setWebClient() {
        return WebClient.builder()
                .baseUrl(mocksApiUrl)
                .build();
    }

}
