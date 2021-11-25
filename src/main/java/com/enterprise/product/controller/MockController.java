package com.enterprise.product.controller;

import com.enterprise.product.service.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@RestController
@RequestMapping("/mocks")
public class MockController {

    private final List<String> NAMES = asList(
            "Fire TV Stick with Alexa Voice Remote, HD streaming device",
            "Echo Dot (3rd Gen, 2018 release) - Smart speaker with Alexa - Charcoal",
            "Introducing Blink Video Doorbell | Two-way audio, HD video, motion and chime app…",
            "Fujifilm Instax Mini 9 Holiday Bundle 2021 - Ice Blue",
            "Deeprio Smart Watch for Android iOS Phones, 1.52 HD Screen Personalized Watch Faces Blood Oxygen ",
            "Insignia - 50-inch Class F30 Series LED 4K UHD Smart Fire TV",
            "Roku Streaming Stick 4K 2021 | Streaming Device 4K/HDR/Dolby Vision with Roku Voice Controls",
            "Apple AirTag",
            "Fire HD 8 Kids tablet, 8 HD display, ages 3-7, 32 GB, Blue Kid-Proof Case");

    private final List<String> MANUFACTURERS = asList(
            "Apple",
            "Samsung",
            "Xiaomi",
            "Lenovo");

    private final Random RANDOM = new Random();

    @GetMapping("/{id}/naming")
    public Mono<Product> getRandomData(@PathVariable Integer id) {

        var product = new Product();
        product.setId(id);
        product.setName(NAMES.get(RANDOM.nextInt(NAMES.size())));
        product.setLongDescription(randomAlphabetic(100));
        return Mono.just(product);
    }

    @GetMapping("/{id}/manufacturing")
    public Mono<Product> getManufacturing(@PathVariable Integer id) {

        var product = new Product();
        product.setId(id);
        product.setManufacturer(MANUFACTURERS.get(RANDOM.nextInt(MANUFACTURERS.size())));
        product.setSku(randomAlphabetic(10));
        return Mono.just(product);
    }
}
