package sparshcoolapps.lambdaexamples.Ex4StreamDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class StoreClient {

    private static volatile boolean firstLine = true;

    public static void main(String... args) throws IOException {
        doDistinctUsingCollectionMap();
        findDistinctItemsUsingStream();
        doSomeSortUsingCollections();
        doSomeSortUsingStreams();
        doStatUsingStreams();
    }

    private static void doDistinctUsingCollectionMap() throws IOException, FileNotFoundException {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/salesdata.csv"))) {

            String line = null;
            Set<Integer> distinctSales = new HashSet<>();
            long startTime = System.currentTimeMillis();

            System.out.println("Starting finding Distinct Items using Collections");

            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String sale = line.split(",")[2];
                if (sale != null) {
                    distinctSales.add(Integer.parseInt(sale));
                }
            }

            System.out.print("First 25 Distinct Items :: ");
            Iterator<Integer> saleIterator = distinctSales.iterator();
            int count = 1;

            while (saleIterator.hasNext() && count++ <= 25) {
                System.out.print(saleIterator.next() + ",");
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("Time Taken for Distinct Items:: " + (endTime - startTime) + " using JDK7 and Collections");
            System.out.println();
            System.out.println();

        }
    }


    private static void findDistinctItemsUsingStream() throws IOException, FileNotFoundException {
        try (Stream<String> linesWithHeader = Files.lines(Paths.get("data/salesdata.csv"))) {

            Stream<String> lines = linesWithHeader.skip(1);
            System.out.println("Starting To Find Distinct Items  ");
            long startTime = System.currentTimeMillis();
            System.out.println("First 25 items:: ");
            lines
                    .map(line -> line.split(","))
                    .mapToInt(rec -> Integer.parseInt(rec[2]))
                    .filter(p -> p != 0)
                    .distinct()
                    .limit(25)
                    .forEach(p -> System.out.print(p + ","));
            long endTime = System.currentTimeMillis();
            System.out.println();
            System.out.println("Time Taken in Distinct :: " + (endTime - startTime) + " Miliseconds ");
            System.out.println();
            System.out.println();
        }
    }


    private static void doSomeSortUsingStreams() throws IOException {

        try (Stream<String> linesWithHeader = Files.lines(Paths.get("data/salesdata.csv"))) {

            Stream<String> lines = linesWithHeader.skip(1);
            System.out.println("Starting Sorted ");

            long startTime = System.currentTimeMillis();

            System.out.println("First 25 items:: ");
            lines
                    .map(line -> line.split(","))
                    .mapToInt(rec -> Integer.parseInt(rec[2]))
                    .filter(p -> p != 0)
                    .sorted()
                    .limit(25)
                    .forEach(p -> System.out.print(p + ","));
            long endTime = System.currentTimeMillis();
            System.out.println();
            System.out.println("Time Taken in Sorted :: " + (endTime - startTime) + " Miliseconds ");
            System.out.println();
            System.out.println();
        }
    }

    private static void doSomeSortUsingCollections() throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/salesdata.csv"))) {
            firstLine = true;
            String line = null;
            List<Integer> salesData = new ArrayList<>();
            long startTime = System.currentTimeMillis();

            System.out.println("Starting Sort using Collections");

            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String sale = line.split(",")[2];
                if (sale != null) {
                    int value = Integer.parseInt(sale);
                    if ( value != 0 )
                    salesData.add(value);
                }
            }

            Collections.sort(salesData);

            System.out.print("First 25 Sale Items :: ");
            Iterator<Integer> saleIterator = salesData.iterator();
            int count = 1;

            while (saleIterator.hasNext() && count++ <= 25) {
                System.out.print(saleIterator.next() + ",");
            }
            System.out.println();
            long endTime = System.currentTimeMillis();
            System.out.println("Time Taken for Distinct Items:: " + (endTime - startTime) + " using Collections");
            System.out.println();
            System.out.println();

        }
    }


    private static void doStatUsingStreams() throws IOException {
        Stream<String> linesWithHeader = Files.lines(Paths.get("data/salesdata.csv"));
        Stream<String> lines = linesWithHeader.skip(1);
        System.out.println("Starting Statistics ");
        long startTime = System.currentTimeMillis();
        IntSummaryStatistics salesStats = lines
                .map(line -> line.split(","))
                .mapToInt(rec -> Integer.parseInt(rec[2]))
                .summaryStatistics();
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken in Statistics  :: " + (endTime - startTime) + " Miliseconds ");
        printStat(salesStats);
        lines.close();
    }

    private static void printStat(IntSummaryStatistics salesStats) {
        System.out.println("" +
                "Sum: " + salesStats.getSum() + " , " +
                "Min: " + salesStats.getMin() + " , " +
                "Max: " + salesStats.getMax() + " , " +
                "Count: " + salesStats.getCount() + " , " +
                "Average: " + salesStats.getAverage());

    }

}
