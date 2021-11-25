package com.enterprise.product;

import com.enterprise.product.service.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static java.lang.Integer.valueOf;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	void givenLoadData_WhenGetFirst_ThenOk() throws Exception {

		webClient.get().uri("/products/1")
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON_VALUE)
				.expectBody(Product.class)
				.value(product -> product.getId(), equalTo(valueOf(1)))
				.value(product -> product.getDetails(), hasSize(2));

	}

	@Test
	void givenLoadData_WhenGetNonExistent_ThenOk() throws Exception {

		webClient.get().uri("/products/8")
				.exchange()
				.expectStatus().isOk();

	}


}
