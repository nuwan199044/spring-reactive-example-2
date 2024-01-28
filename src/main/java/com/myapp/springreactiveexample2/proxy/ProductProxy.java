package com.myapp.springreactiveexample2.proxy;

import com.myapp.springreactiveexample2.entity.Product;
import com.myapp.springreactiveexample2.exception.ProductRetriveException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class ProductProxy {

    private final WebClient webClient;

    public Flux<Product> getAll() {
        var product = new Product(3, "Default");

        return webClient.get().uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
//                .onErrorResume(e -> Flux.just(product));
//                .onErrorResume(WebClientRequestException.class, e -> Flux.just(product));
//                .onErrorResume(e -> e.getMessage() != null, e -> Flux.just(product));
//                .onErrorReturn(product);
//                .onErrorReturn(WebClientRequestException.class, product);
//                .onErrorReturn(e -> e.getMessage() != null, product);
//                .onErrorMap(e -> new ProductRetriveException());
//                .doOnNext(e -> {
//                    if (e.getName() == null) throw new RuntimeException();
//                })
//                .onErrorContinue((exception, object) -> System.out.println(exception.getMessage()));
//                .onErrorContinue(RuntimeException.class, (exception, object) -> System.out.println(exception.getMessage()));
//                .onErrorContinue(e -> e.getMessage() != null, (exception, object) -> System.out.println(exception.getMessage()));
                .retry(1);
    }

}
