package com.enterprise.product.persistence.repository;

import com.enterprise.product.persistence.entity.ProductDetailEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductDetailRepository extends ReactiveCrudRepository<ProductDetailEntity, Integer> {

    Flux<ProductDetailEntity> findByIdProduct(Integer idProduct);

}