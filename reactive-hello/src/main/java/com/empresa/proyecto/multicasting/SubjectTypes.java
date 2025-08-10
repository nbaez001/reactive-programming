package com.empresa.proyecto.multicasting;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

import java.util.concurrent.TimeUnit;

public class SubjectTypes {
    public static void main(String[] args) throws InterruptedException {
        Subject<Long> subject = UnicastSubject.create();
        Observable.interval(500, TimeUnit.MILLISECONDS)
                .subscribe(subject);
        Thread.sleep(2000);

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
        Thread.sleep(2000);
    }
}
