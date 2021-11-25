package com.enterprise.product.persistence.impl;

import com.enterprise.product.persistence.ProductDao;
import com.enterprise.product.persistence.mapper.ProductEntityMapper;
import com.enterprise.product.persistence.repository.ProductRepository;
import com.enterprise.product.service.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private ProductRepository repository;
    private ProductEntityMapper mapper;

    @Override
    public Mono<Product> findById(final Integer id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Product> save(final Product product) {
        return repository.save(mapper.toEntity(product))
                .map(mapper::toDomain);
    }
}
