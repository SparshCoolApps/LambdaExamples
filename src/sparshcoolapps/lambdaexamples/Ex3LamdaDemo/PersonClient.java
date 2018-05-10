package sparshcoolapps.lambdaexamples.Ex3LamdaDemo;

import amdocs.demoppt.common.DataHelper;
import amdocs.demoppt.common.Person;
import amdocs.demoppt.common.PrintFormatter;
import amdocs.demoppt.common.SimpleFormatter;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonClient {

    public static void main(String ...args) throws IOException {

        // Get the People data
        List<Person> people = DataHelper.getPeople();

        // Common Formatter
        PrintFormatter starHashFormatter = new SimpleFormatter("@#*");

        // Step - 1 print All People
        performConditionally(people, p -> true, p -> System.out.println(p), starHashFormatter, "ALL Persons data");

        // Step - 2 print All People whose first name start with A
        performConditionally(people,
                p-> p.getFirstName().startsWith("A"),
                System.out :: println,
                starHashFormatter,
                "Persons Whose First Name Start's with A");

        // Step - 3 print All People whose last name start with A
        performConditionally(people,
                p-> p.getLastName().startsWith("A"),
                System.out :: println,
                starHashFormatter,
                "Persons Whose Last Name Start's with A");

        // Step - 4 print All People whose last name start with A and State name start with N
        performConditionally(people,
                p-> p.getLastName().startsWith("A") && p.getState().startsWith("N"),
                System.out :: println,
                starHashFormatter,
                "People whose last name start with A and State name start with N");

        // Step - 5 print All People sorted by Last name and their first name start with A
        List<Person> filteredPersonsByFirstName = filterConditionally(people, p -> p.getFirstName().startsWith("A"));
        Collections.sort(filteredPersonsByFirstName, (p1 ,p2) -> p1.getLastName().compareTo(p2.getLastName()));
        performConditionally(people,
                        p->true,
                        System.out :: println,
                        starHashFormatter,
                        "All People sorted by Last name and their first name start with A");

        // Bonus Step - print All People sorted by company name first and then last name
        Collections.sort(people, Comparator.comparing(Person::getCompanyName).thenComparing(Person::getLastName));
        performConditionally(people,
                p -> true,
                System.out :: println,
                starHashFormatter,
                "Print All People sorted by company name first and then last name");

        // Step - 6 Print All People in sorted order by their Company whose state is NY
        List<Person> filteredPersonsByState = filterConditionally(people, p -> p.getFirstName().equalsIgnoreCase("NY"));
        Collections.sort(filteredPersonsByState, Comparator.comparing(Person::getCompanyName));
        performConditionally(filteredPersonsByState,
                p -> true,
                System.out :: println,
                starHashFormatter,
                "Print All People in sorted order by their Company whose state is NY");

        // Ex: 7 - Can you print how many persons belongs to each state?

        // Step 7.1 - Create a Map<String,Integer> for counts in each state
        Map<String, Integer> personCountMap = countPersonInEachState(people);

        // Step 7.2 - Print state and counts
        printPersonCountsInState(personCountMap);

    }

    public static List<Person> filterConditionally (List<Person> people, Predicate<Person> condition){
        List<Person> filterPeople = new ArrayList<>();
        for (Person p: people){
            if (condition.test(p)){
                filterPeople.add(p);
            }
        }
        return filterPeople;
    }

    public static  void printPersonCountsInState(Map<String, Integer> countMap){
        // Pre-Action Before Main Action
        System.out.println("State ----> Person Counts");
        // Filler for Pre-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        int total = 0;
        for (String key : countMap.keySet()){
            total += countMap.get(key);
            System.out.println(key+" ----> "+countMap.get(key));
        }
        System.out.println("Total Persons ::"+ total);
    }
    public static Map<String, Integer> countPersonInEachState(List<Person> people){
        Map<String, Integer> countMap = new HashMap<>();
        for (Person person: people){
            if (countMap.containsKey(person.getState()))
                countMap.put(person.getState(),countMap.get(person.getState())+1);
            else
                countMap.put(person.getState(), 1);
        }
        return countMap;
    }

    public static void performConditionally(List<Person> people, Predicate<Person> condition,
                                            Consumer<Person> action, PrintFormatter formatter,
                                            String message) {
        formatter.prePrint(message);
        for (Person p:people){
            if ( condition.test(p))
                action.accept(p);
        }
        formatter.postPrint();
    }
}

