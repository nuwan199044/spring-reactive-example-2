package com.myapp.springreactiveexample2.controller;

import com.myapp.springreactiveexample2.publisher.DemoPublisher;
import com.myapp.springreactiveexample2.subscriber.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @GetMapping
    public void demo() {
        DemoPublisher publisher = new DemoPublisher(List.of(1,2,3,4,5,6,7,8,9));
        publisher.subscribe(new DemoSubscriber());
    }
}
