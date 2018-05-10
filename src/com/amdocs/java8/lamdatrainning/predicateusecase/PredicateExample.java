package com.amdocs.java8.lamdatrainning.predicateusecase;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String ...args){

        List<Person> people = Arrays.asList(
                new Person("Amarjeet","Rathor",30,"Pune"),
                new Person("Girjesh","Trivedi",30,"Pune"),
                new Person("Roshik","Mohammad",35,"Kochi"),
                new Person("Sagar","Trivedi",35,"Kanpur"),
                new Person("Ashish","Verma",35,"Kanpur"),
                new Person("Saurabh","Rathor",28,"Delhi"));


        people.sort((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()));
        performConditionally(people, p -> true, System.out::println);
        System.out.println("All People First Name Start with A and V");
        performConditionally(people, ((Predicate<Person> )p -> p.getFirstName().startsWith("A"))
                .and(p-> p.getLastName().startsWith("V")),System.out::println);


        List<String> filtered = people.stream()
                                        .filter(Objects::nonNull)
                                        .filter(p-> p.getAge() > 30)
                                       .map(p -> p.getFirstName())
                                       .collect(Collectors.toList());
        filtered.forEach(System.out::println);
    }

    private static void performConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> action){
        for (Person p: people){
            if (condition.test(p)){
                action.accept(p);
            }
        }
    }
}
