package com.enterprise.product.controller;

import com.enterprise.product.service.ProductService;
import com.enterprise.product.service.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private ProductService productService;

    /*
    TODO: global error handling
    TODO: getById NOT_FOUND

     */

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Mono<Product> getById(@PathVariable Integer id) {
        return productService.getById(id)
                .map(product -> product);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<Product> create(@Valid @RequestBody Product product) {

        if (nonNull(product.getId())) {
            return Mono.error(() -> new RuntimeException("Id value must not be setted"));
        }
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public Mono<Product> update(
            @Valid @RequestBody Product product,
            @PathVariable(value = "id") Integer id) {

        if (isNull(product.getId())) {
            return Mono.error(() -> new RuntimeException("Id value must be setted"));
        }

        return productService.save(product);
    }


}


