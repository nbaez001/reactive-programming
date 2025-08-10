package com.empresa.proyecto.combining;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Concat {
    public static void main(String[] args) throws InterruptedException {
        //merge
        System.out.println("--- merge ---");
        Observable<String> src1Str = Observable.just("Ella", "Alexa", "Lily");
        Observable<String> src2Str = Observable.just("Priya", "Chloe");
        Observable.concat(src1Str, src2Str)
                .subscribe(System.out::println);

        Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(e -> "src1: " + e);
        Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS)
                .map(e -> "src2: " + e);
        src1.concatWith(src2)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
