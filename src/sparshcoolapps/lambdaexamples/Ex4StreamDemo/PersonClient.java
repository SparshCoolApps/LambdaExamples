package sparshcoolapps.lambdaexamples.Ex4StreamDemo;

import amdocs.demoppt.common.DataHelper;
import amdocs.demoppt.common.Person;

import java.io.IOException;

import static java.util.stream.Collectors.*;

public class PersonClient {

    public static void main(String... args) throws IOException {

        // Get the People data
        List<Person> people = DataHelper.getPeople();

        // Step - 1 print All People
        people.forEach(System.out::println);

        // Step - 2 print All People whose name starts with "A"
        people.stream()
                .filter(p -> p.getFirstName().startsWith("A"))
                .forEach(System.out::println);

        // Step - 3 print All People whose last name starts with "A"
        people.stream()
                .filter(p -> p.getLastName().startsWith("A"))
                .forEach(System.out::println);

        // step - 4 print All People whose last name start with A and State name start with N
        people.stream()
                .filter(p -> p.getLastName().startsWith("A") && p.getState().startsWith("N"))
                .forEach(System.out::println);


        // step - 5 print All People sorted by Last name and their first name start with A
        people.stream()
                .filter(p -> p.getFirstName().startsWith("A"))
                .sorted(Comparator.comparing(Person::getLastName))
                .forEach(System.out::println);

        // step - 6 print All People sorted by Last name and their first name start with A
        people.stream()
                .sorted(Comparator.comparing(Person::getCompanyName)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .forEach(System.out::println);

        // step - 6 print All People sorted by Last name and their first name start with A
        people.stream()
                .filter(p -> p.getState().equalsIgnoreCase("NY"))
                .sorted(Comparator.comparing(Person::getCompanyName))
                .forEach(System.out::println);

        people.stream()
                .collect(groupingBy(Person::getState))
                .entrySet()
                .stream()
                .forEach(x -> System.out.println("Key==>" + x.getKey() + "  Counts ==>" + x.getValue().size()));

        people.stream()
                .collect(groupingBy(Person::getState, counting()))
                .entrySet()
                .forEach(x -> System.out.println("Key==>" + x.getKey() + "  Counts ==>" + x.getValue()));


        List<String> data = people.stream()
                .map(x -> Arrays.asList(x.getFirstName(), x.getLastName(), x.getCompanyName(), x.getCity(), x.getCountry()))
                .limit(3)
                .flatMap(items -> items.stream())
                .collect(toList());
        data.forEach(p -> System.out.print(p + ","));
    }
}
