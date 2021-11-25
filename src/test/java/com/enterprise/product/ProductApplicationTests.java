package com.enterprise.product;

import com.enterprise.product.service.model.Product;
import com.enterprise.product.service.model.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static java.util.List.of;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void givenLoadData_WhenGetFirst_ThenOk() {
		webClient.get().uri("/products/1")
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON_VALUE)
				.expectBody(Product.class)
				.value(Product::getId, equalTo(1))
				.value(Product::getDetails, hasSize(2));
	}

	@Test
	void givenLoadData_WhenGetNonExistent_ThenBadRequest() {
		webClient.get().uri("/products/what")
				.exchange()
				.expectStatus().isBadRequest();
	}

	@Test
	void whenCreate_ThenCreated() {

		var product = new Product();
		product.setCategory("PHONE");
		product.setDetails(
				of(getDetail(null, null, "USA", 213f, 465, 46f),
						getDetail(null, null, "FRA", 12f, 500, 2f)));

		webClient
				.post()
				.uri("/products")
				.body(Mono.just(product), Product.class)
				.exchange()
				.expectStatus().isEqualTo(CREATED)
				.expectBody()
				.jsonPath("$.id").value(is(notNullValue()))
				.jsonPath("$.details", hasSize(2));
	}

	@Test
	void whenCreateWithoutDetails_ThenBadRequest() {

		var product = new Product();
		product.setCategory("PHONE");

		webClient
				.post()
				.uri("/products")
				.body(Mono.just(product), Product.class)
				.exchange()
				.expectStatus()
				.isEqualTo(BAD_REQUEST);

	}


	@Test
	void whenSave_ThenCreated() {

		var product = new Product();

		product.setId(1);
		product.setCategory("UPDATE");
		product.setName("some cache name");
		product.setLongDescription("some very long description");
		product.setManufacturer("Apple");
		product.setSku("sku-chAnge");
		product.setDetails(
				of(getDetail(1, 1, "USA", 213f, 465, 46f),
						getDetail(2, 1, "FRA", 12f, 500, 2f)));

		webClient
				.put()
				.uri("/products/1")
				.body(Mono.just(product), Product.class)
				.exchange()
				.expectStatus().isEqualTo(OK)
				.expectBody()
				.jsonPath("$.id").value(is(notNullValue()))
				.jsonPath("$.details", hasSize(2));
	}


	private ProductDetail getDetail(
			final Integer id,
			final Integer idProduct,
			final String country,
			final Float price,
			final Integer stock,
			final Float shippingFee) {
		var detail = new ProductDetail();
		detail.setId(id);
		detail.setIdProduct(idProduct);
		detail.setCountry(country);
		detail.setCountry(country);
		detail.setPrice(price);
		detail.setStock(stock);
		detail.setShippingFee(shippingFee);

		return detail;
	}

}
