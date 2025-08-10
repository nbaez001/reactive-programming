package com.empresa.proyecto.combining;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;

public class FlatMapConcatMap {
    public static void main(String[] args) {
        List<String> list = List.of("Hello", "Reactive", "Programming");
        System.out.println("--- flatMap ---");
        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

        System.out.println("--- concatMap ---");
        Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);
    }
}
