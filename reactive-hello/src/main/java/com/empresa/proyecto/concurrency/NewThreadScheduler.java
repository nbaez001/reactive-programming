package com.empresa.proyecto.concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewThreadScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow main")
                .subscribeOn(Schedulers.newThread());

        src.subscribe(e -> task());
        Thread.sleep(6000);

        src.subscribe(e -> task());
        src.subscribe(e -> task());
        src.subscribe(e -> task());
        Thread.sleep(50000);
    }

    public static void task() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
