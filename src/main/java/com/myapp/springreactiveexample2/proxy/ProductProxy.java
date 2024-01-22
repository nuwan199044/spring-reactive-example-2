package com.myapp.springreactiveexample2.proxy;

import com.myapp.springreactiveexample2.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProductProxy {

    private final WebClient webClient;

    public Flux<Product> getAll() {
        return webClient.get().uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class));
    }

}
