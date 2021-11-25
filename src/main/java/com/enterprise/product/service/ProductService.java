package com.enterprise.product.service;

import com.enterprise.product.service.model.Product;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> getById(Integer id);

    Mono<Product> save(Product product);
}
