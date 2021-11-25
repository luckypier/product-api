package com.enterprise.product.persistence.mapper;

import com.enterprise.product.persistence.entity.ProductDetailEntity;
import com.enterprise.product.service.model.ProductDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailEntityMapper {

    ProductDetail toDomain(ProductDetailEntity productDetailEntity);
    ProductDetailEntity toEntity(ProductDetail productDetail);
}
