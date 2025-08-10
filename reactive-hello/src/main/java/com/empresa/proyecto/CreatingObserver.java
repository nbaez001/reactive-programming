package com.empresa.proyecto;

import io.reactivex.rxjava3.core.Observable;

public class CreatingObserver {
    public static void main(String[] args) {
        //overload with three lambdas
        Observable<String> source = Observable.just("Orange", "Black", "Red");
        source.subscribe(
                i -> System.out.println(i),
                Throwable::printStackTrace,
                () -> System.out.println("Completed!"));

        //overload with two lambdas
        source.subscribe(
                i -> System.out.println(i),
                Throwable::printStackTrace);

        //overload with one lambdas
        source.subscribe(
                i -> System.out.println(i));
    }
}
