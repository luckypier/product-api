package com.enterprise.product.persistence.mapper;

import com.enterprise.product.persistence.entity.ProductEntity;
import com.enterprise.product.service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    Product toDomain(ProductEntity productEntity);
    ProductEntity toEntity(Product product);
}
