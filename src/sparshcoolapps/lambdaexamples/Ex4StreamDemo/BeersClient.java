package sparshcoolapps.lambdaexamples.Ex4StreamDemo;

import amdocs.demoppt.common.Beer;
import amdocs.demoppt.common.DataHelper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BeersClient {

    public static void main(String... args) throws IOException {
        List<Beer> beers = DataHelper.getBeers();

        long startTime = System.currentTimeMillis();
        Long sum = beers.stream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in Sum (Single Stream)::" + (endTime - startTime) + "  Sum:: " + sum);

        startTime = System.currentTimeMillis();
        sum = beers.parallelStream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken in Counting (Parallel Stream)::" + (endTime - startTime) + "  Sum:: " + sum);

/*
        doCounting(beers);
        doSum(beers);
*/
    }


    private static void doCounting(List<Beer> beers) {

        long startTime = System.currentTimeMillis();
        Long count = beers.stream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .count();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in Counting (Single Stream)::" + (endTime - startTime) + "  Count:: " + count);

        startTime = System.currentTimeMillis();
        count = beers.parallelStream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .count();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken in Counting (Parallel Stream)::" + (endTime - startTime) + "  Count:: " + count);
    }

    private static void doSum(List<Beer> beers){

        long startTime = System.currentTimeMillis();
        Long sum = beers.stream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken in Sum (Single Stream)::" + (endTime - startTime) + "  Sum:: " + sum);

        startTime = System.currentTimeMillis();
        sum = beers.parallelStream()
                .filter(Objects::nonNull)
                .mapToLong(Beer::getBreweryID)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken in Counting (Parallel Stream)::" + (endTime - startTime) + "  Sum:: " + sum);
    }


}
