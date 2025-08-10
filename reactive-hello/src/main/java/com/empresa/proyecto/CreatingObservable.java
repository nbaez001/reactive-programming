package com.empresa.proyecto;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CreatingObservable {
    public static void main(String[] args) throws InterruptedException {
        //create
        System.out.println("--- create ---");
        Observable<Integer> source = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();
                }
        );
        source.subscribe(System.out::println);

        //just
        System.out.println("--- just ---");
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        //fromIterable
        System.out.println("--- fromIterable ---");
        List<String> list = List.of("Ram", "Shyam", "Mike");
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);

        //range
        System.out.println("--- range ---");
        Observable
                .range(3, 10)
                .subscribe(System.out::println);

        //fromFuture
        System.out.println("--- fromFuture ---");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Future!";
        });
        Observable.fromFuture(future)
                .subscribe(System.out::println);
        executor.shutdown();

        //interval
        System.out.println("--- interval (take 5) ---");
        Observable
                .interval(1, TimeUnit.SECONDS)
                .take(5)
                .subscribe(System.out::println);
        Thread.sleep(6000);

        //empty
        System.out.println("--- empty ---");
        Observable
                .empty()
                .subscribe(System.out::println);

        //never
        System.out.println("--- never ---");
        Observable
                .never()
                .subscribe(System.out::println);
        Thread.sleep(2000);

        //defer
        System.out.println("--- defer ---");
        List<String> lista = new ArrayList<>();
        lista.add("Ram");
        lista.add("Mike");
        Observable<String> defer = Observable
                .defer(() -> Observable.fromIterable(lista));
        defer.subscribe(System.out::println);

        lista.add("Paul");
        defer.subscribe(System.out::println);

        //error
        System.out.println("--- error ---");
        Observable
                .error(() -> new RuntimeException("Exception"))
                .subscribe(System.out::println);

        //callable
        System.out.println("--- callable ---");
        //
    }
}
