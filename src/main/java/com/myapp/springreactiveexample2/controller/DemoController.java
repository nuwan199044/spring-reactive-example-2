package com.myapp.springreactiveexample2.controller;

import com.myapp.springreactiveexample2.subscriber.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Set;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {
        Flux<Integer> f1 = Flux.just(1,2,3,4,5,6);
        Flux<Integer> f2 = Flux.fromStream(Stream.of(1,2,3,4,5,6));
        Flux<Integer> f3 = Flux.fromIterable(Set.of(1,2,3,4,5));

        f1.doOnNext(e -> {throw new RuntimeException("Oooops !!");})
                .subscribe(new DemoSubscriber());
    }
}
