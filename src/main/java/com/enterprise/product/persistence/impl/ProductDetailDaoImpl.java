package com.enterprise.product.persistence.impl;

import com.enterprise.product.persistence.ProductDetailDao;
import com.enterprise.product.persistence.mapper.ProductDetailEntityMapper;
import com.enterprise.product.persistence.repository.ProductDetailRepository;
import com.enterprise.product.service.model.ProductDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class ProductDetailDaoImpl implements ProductDetailDao {

    private ProductDetailRepository repository;
    private ProductDetailEntityMapper mapper;

    @Override
    public Flux<ProductDetail> findByIdProduct(final Integer idProduct) {
        return repository.findByIdProduct(idProduct)
                .map(mapper::toDomain);
    }

    @Override
    public Flux<ProductDetail> saveAll(final List<ProductDetail> details) {

        return repository.saveAll(details.stream()
                        .map(mapper::toEntity)
                        .collect(toList()))
                .map(mapper::toDomain);
    }
}
