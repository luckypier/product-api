package com.enterprise.product.service.impl;

import com.enterprise.product.client.ProductClient;
import com.enterprise.product.persistence.ProductDao;
import com.enterprise.product.persistence.ProductDetailDao;
import com.enterprise.product.service.ProductService;
import com.enterprise.product.service.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.toList;
import static reactor.core.publisher.Flux.zip;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    private ProductDetailDao productDetailDao;
    private ProductClient productClient;

    @Override
    public Mono<Product> getById(final Integer id) {

        return productDao.findById(id)
                .flatMap(savedProduct -> zip(
                        productDetailDao.findByIdProduct(id).collectList(),
                        productClient.getNames(id),
                        productClient.getManufacturing(id))
                        .flatMap(data -> {
                            var details = data.getT1();
                            var cached = data.getT2();
                            var external = data.getT3();

                            var product = new Product();
                            product.setId(savedProduct.getId());
                            product.setCategory(savedProduct.getCategory());
                            product.setDetails(details);
                            product.setName(cached.getName());
                            product.setLongDescription(cached.getLongDescription());
                            product.setManufacturer(external.getManufacturer());
                            product.setSku(external.getSku());
                            return Mono.just(product);
                        })
                        .singleOrEmpty());
    }

    //TODO: transactional, not found exception

    @Override
    public Mono<Product> save(final Product product) {

        return productDao.save(product)
                .flatMap(saved -> {

                    var details =
                            product.getDetails().stream()
                                    .peek(productDetail -> productDetail.setIdProduct(saved.getId()))
                                    .collect(toList());

                    return productDetailDao.saveAll(details)
                            .collectList()
                            .flatMap(productDetail -> getById(saved.getId()));
                });
    }

}
