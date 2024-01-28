package com.myapp.springreactiveexample2.controller;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
public class DemoController {

    @GetMapping
    public void demo() {
        Flux<String> f1 = Flux.create(s -> {
            for (int i=0; i <10; i++) {
                s.next(UUID.randomUUID().toString());
            }
            s.complete();
        });
        f1.log().subscribe(new Subscriber<String>() {

            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
