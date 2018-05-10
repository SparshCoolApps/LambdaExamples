package sparshcoolapps.lambdaexamples.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataHelper {


    public static List<Beer> getBeers() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data/beers.csv"));
        return lines
                .skip(1)
                .map(line -> line.split(","))
                .map(rec -> Beer.newInstance(rec))
                .collect(Collectors.toList());
    }

    public static List<Beer> getBeers() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data/beers.csv"));
        return lines
                .skip(1)
                .map(line -> line.split(","))
                .map(rec -> Beer.newInstance(rec))
                .collect(Collectors.toList());
    }

    public static List<BeerShopLocation> getBeerShops() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data/breweries.csv"));
        return lines
                .skip(1)
                .map(line -> line.split(","))
                .map(rec -> new BeerShopLocation(Integer.parseInt(rec[0]),
                        rec[1], rec[2], rec[3]))
                .collect(Collectors.toList());

    }

    public static List<Person> getPeopleImperativeWay() throws IOException {

        List<Person> personList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data/people.csv"))) {
            boolean firstLine = true;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String rec[] = line.split(",");
                personList.add(new new Person(rec[0], rec[1], rec[2], rec[3], rec[4], rec[5],
                        rec[6], rec[7], rec[8], rec[9], rec[10], rec[11]));
            }
        }

        return personList;
    }


    public static List<Person> getPeople() throws IOException {
        Stream<String> lines = Files.lines(Paths.get("data/people.csv"));
        return lines
                .skip(1)
                .map(line -> line.split(","))
                .map(rec -> new Person(rec[0], rec[1], rec[2], rec[3], rec[4], rec[5], rec[6],
                        rec[7], rec[8], rec[9], rec[10], rec[11]))
                .collect(Collectors.toList());

    }

    public static void main(String... args) throws IOException {
        List<Person> people = getPeople();
        people.stream()
                .filter(p -> p.getCity().equalsIgnoreCase("New Orleans"))
                .forEach(System.out::println);
    }

}
