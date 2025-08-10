package com.empresa.proyecto.concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SingleScheduler {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow main")
                .subscribeOn(Schedulers.single());

        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        Thread.sleep(50000);
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
