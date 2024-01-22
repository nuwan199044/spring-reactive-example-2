package com.myapp.springreactiveexample1.service;

import com.myapp.springreactiveexample1.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    public Flux<Product> getAll() {
        var p1 = new Product(1, "Beer");
        var p2 = new Product(2, "Chocolate");
        return Flux.fromStream(Stream.of(p1, p2))
                .delayElements(Duration.ofSeconds(3));
    }

}
