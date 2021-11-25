package com.enterprise.product.client.impl;

import com.enterprise.product.client.ProductClient;
import com.enterprise.product.service.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@CacheConfig(cacheNames = {"products"})
@AllArgsConstructor
public class ProductClientImpl implements ProductClient {

    private final WebClient webClient;

    @Override
    @Cacheable
    public Mono<Product> getNames(final Integer id) {

        return webClient.get()
                .uri("/mock/{id}/naming", id)
                .retrieve().bodyToMono(Product.class)
                .cache();
    }

    @Override
    public Mono<Product> getManufacturing(final Integer id) {

        return webClient.get()
                .uri("/mock/{id}/manufacturing", id)
                .retrieve().bodyToMono(Product.class)
                .cache();
    }
}
