package com.enterprise.product.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    //local DB
    private Integer id;
    private String category;

    //external call with cache
    private String name;
    private String longDescription;

    //external call
    private String manufacturer;
    private String sku;

    //others
    private List<ProductDetail> details;

}
