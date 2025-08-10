package com.empresa.proyecto.concurrency;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomScheduler {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(20);
        Scheduler scheduler = Schedulers.from(executor);

        Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow main")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown);

        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
        src.subscribe(e -> sensitiveTask());
    }

    public static void sensitiveTask() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
