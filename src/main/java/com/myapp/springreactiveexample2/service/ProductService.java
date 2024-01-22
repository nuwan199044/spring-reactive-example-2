package com.myapp.springreactiveexample2.service;

import com.myapp.springreactiveexample2.entity.Product;
import com.myapp.springreactiveexample2.proxy.ProductProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductProxy proxy;

    public Flux<Product> getAll() {
        return proxy.getAll();
    }

}
