package com.empresa.proyecto.combining;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void main(String[] args) {
        Observable<Employee2> obs = Observable.just(
                new Employee2(101, "Alexa", 60000, 4.0),
                new Employee2(123, "Dhwanit", 94000, 4.7),
                new Employee2(236, "Mike", 65000, 4.0),
                new Employee2(155, "Ella", 85000, 4.4),
                new Employee2(443, "George", 50000, 3.6),
                new Employee2(127, "Shreeja", 85000, 4.5),
                new Employee2(509, "Daniel", 60000, 4.0),
                new Employee2(344, "Lucy", 94000, 4.7),
                new Employee2(509, "Harry", 75000, 4.3),
                new Employee2(344, "Emma", 55000, 3.7)
        );

        obs.groupBy(e -> e.getRating())
                .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), Employee2::getName))
                .subscribe(System.out::println);
    }
}

class Employee2 {
    private Integer id;
    private String name;
    double salary, rating;

    public Employee2(Integer id, String name, double salary, double rating) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", rating=" + rating +
                '}';
    }
}