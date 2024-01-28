package com.myapp.springreactiveexample2.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {

    Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("on subscribe");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("on next "+ integer);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("on throwable "+throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("on complete");
    }
}
