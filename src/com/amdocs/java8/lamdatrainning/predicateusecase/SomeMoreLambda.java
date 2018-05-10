package com.amdocs.java8.lamdatrainning.predicateusecase;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class SomeMoreLambda {


    public static  void main (String ...args){
        Person person = new Person("Amarjeet","Rathor",30,"Pune");
        MessageProcessor processor = (p) -> () -> "Success";

        System.out.println(printAndProcess(processor));
    }
    public static String printAndProcess(MessageProcessor processor){
        return processor.process(System.out::println).get();

    }
}





@FunctionalInterface
interface MessageProcessor {
    public Supplier<String> process(Consumer<Person> consumer);
}
