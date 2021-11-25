package com.enterprise.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.List;

@Slf4j
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		log.info("demo info");
		log.debug("demo debug");

		SpringApplication.run(ProductApplication.class, args);

//
//		// a flux that contains 6 elements.
//		final Flux<Integer> fluzzz = Flux.fromIterable(List.of(1,2,3,4,5,6));
//
//		// a mono of 1 element.
//		final Mono<String> monos = Mono.just("someGroupLabel");
//
//
//
////		// wrong way - this will only emit 1 event
////		final Flux<Tuple2<Integer, String>> wrongWayOfZippingFluxToMono = userIds
////				.zipWith(groupLabel);
////
////		// you'll see that onNext() is only called once,
////		//     emitting 1 item from the mono and first item from the flux.
////		wrongWayOfZippingFluxToMono
////				.log()
////				.subscribe()
////		;
//
//		// this is how to zip up the flux and mono how you'd want,
//		//     such that every time the flux emits, the mono emits.
//		final Flux<Tuple2<Integer, String>> zipped = fluzzz
//				.flatMap(userId -> Mono.just(userId)
//						.zipWith(monos))
//
//				;
//
//		// you'll see that onNext() is called 6 times here, as desired.
//		zipped
//				.log()
//				.subscribe();
	}

}
