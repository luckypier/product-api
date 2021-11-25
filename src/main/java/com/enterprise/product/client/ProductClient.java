package com.enterprise.product.client;

import com.enterprise.product.service.model.Product;
import reactor.core.publisher.Mono;

public interface ProductClient {

    Mono<Product> getNames(Integer id) ;

    Mono<Product> getManufacturing(final Integer id);
}
