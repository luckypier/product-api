package com.enterprise.product.service.model;

import lombok.Data;

@Data
public class ProductDetail {

    private Integer id;

    private Integer idProduct;

    private String country;

    private Float price;

    private Integer stock;

    private Float shippingFee;

}
