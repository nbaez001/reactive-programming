package com.empresa.proyecto.buffering;

import io.reactivex.rxjava3.core.Observable;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Buffering {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("---- Example 1 ----");
        Observable.range(1, 30)
                .buffer(4)
                .subscribe(System.out::println);

        System.out.println("---- Example 2 ----");
        Observable.range(1, 30)
                .buffer(4, HashSet::new)
                .subscribe(System.out::println);

        System.out.println("---- Example 3 ----");
        Observable.range(1, 30)
                .buffer(4, 4)
                .subscribe(System.out::println);

        System.out.println("---- Example 4 ----");
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        Thread.sleep(8000);

        System.out.println("---- Example 5 ----");
        Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);
        Observable.interval(1000, TimeUnit.MILLISECONDS)
                .buffer(interval)
                .subscribe(System.out::println);
        Thread.sleep(8000);
    }
}
