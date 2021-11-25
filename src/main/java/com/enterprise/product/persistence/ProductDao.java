package com.enterprise.product.persistence;

import com.enterprise.product.service.model.Product;
import reactor.core.publisher.Mono;

public interface ProductDao {

    Mono<Product> findById(Integer id);
    Mono<Product> save(Product product);
}
