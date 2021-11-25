package com.enterprise.product.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("product")
public class ProductEntity {

    @Id
    private Integer id;

//    private String name;

//    private String manufacturer;

    private String category;

//    private String longDescription;

//    private String sku;
}