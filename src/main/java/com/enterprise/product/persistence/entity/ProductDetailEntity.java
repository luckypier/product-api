package com.enterprise.product.persistence.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("product_detail")
public class ProductDetailEntity {

    @Id
    @Column("id")
    private Integer id;

    @Column("id_product")
    private Integer idProduct;

    @Column("country")
    private String country;

    @Column("price")
    private Float price;

    @Column("stock")
    private Integer stock;

    @Column("shipping_fee")
    private Float shippingFee;
}