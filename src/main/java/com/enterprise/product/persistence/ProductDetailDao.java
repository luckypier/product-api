package com.enterprise.product.persistence;

import com.enterprise.product.service.model.ProductDetail;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ProductDetailDao {

    Flux<ProductDetail> findByIdProduct(Integer idProduct);

    Flux<ProductDetail> saveAll(final List<ProductDetail> details);
}
