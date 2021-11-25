package com.enterprise.product.service.model;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class ProductDetail {

    private Integer id;

    private Integer idProduct;

    @Size(min = 3, max = 10)
    private String country;

    @PositiveOrZero
    private Float price;

    @PositiveOrZero
    private Integer stock;

    @PositiveOrZero
    private Float shippingFee;

}
