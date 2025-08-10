package com.empresa.proyecto;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {
        //single
        System.out.println("--- single ---");
        Observable<String> source = Observable.just("Alex", "Justin", "Jack");
        source
                .first("Name")
                .subscribe(System.out::println);

        Single.just("Carlos")
                .subscribe(System.out::println);

        //maybe
        System.out.println("--- maybe ---");
        source
                .firstElement()
                .subscribe(System.out::println);

        Observable<String> source2 = Observable.empty();
        source2
                .firstElement()
                .subscribe(System.out::println,
                        e -> e.printStackTrace(),
                        () -> System.out.println("Completed!"));

        //completable
        System.out.println("--- completable ---");
        Completable completable = Completable.complete();
        completable.subscribe(
                () -> System.out.println("Completed")
        );

        Completable
                .fromRunnable(() -> System.out.println("Some process executing"))
                .subscribe(() -> System.out.println("The process executed succesfully"));

    }
}
