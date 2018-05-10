package sparshcoolapps.lambdaexamples.Ex1AnonymousClassDemo;

import amdocs.demoppt.common.DataHelper;
import amdocs.demoppt.common.Person;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonClient {

    public static void main(String ...args) throws IOException{

        // Get the People data
        List<Person> people = DataHelper.getPeople();

        // Step - 1 print All People
        printAll(people);

        // Step - 2 print All People whose first name start with A
        printAllFirstNameStartsWith(people,"A");

        // Step - 3 print All People whose last name start with A
        printAllLastNameStartsWith(people,"A");

        // Step - 4 print All People in sorted order by last name whose first name start with A
        // Step - 4.1 filter all the records whose first name start with A
        List<Person> filteredPersonsByFirstName = filterPersonsByFirstName(people,"A");

        // Step - 4.2 Sort the filtered records from new Collections
        filteredPersonsByFirstName = sortPeopleByFirstName(filteredPersonsByFirstName);

        // Step - 4.3 print all the filtered and sorted records from new Collections
        printAll(filteredPersonsByFirstName);


        // Step - 5 print All People in sorted order by their Company whose last name start with A
        // Step - 5.1 filter all the records whose last name start with A
        List<Person> filteredPersonsByLastName = filterPersonsByLastName(people,"A");

        // Step - 5.2 Sort the filtered records from new Collections
        filteredPersonsByLastName = sortPeopleByCompanyName(filteredPersonsByLastName);

        // Step - 5.3 print all the filtered and sorted records from new Collections
        printAll(filteredPersonsByLastName);


        // Step - 6 print All People in sorted order by their Company whose state is NY
        // Step - 6.1 filter all the records whose state is NY
        List<Person> filteredPersonsBySate = filterPersonsByState(people,"NY");

        // Step - 6.2 Sort the filtered records from new Collections
        filteredPersonsByLastName = sortPeopleByCompanyName(filteredPersonsBySate);

        // Step - 6.3 print all the filtered and sorted records from new Collections
        printAll(filteredPersonsBySate);

        // Ex:6 - Can you print how many persons belongs to each state?

        // Step 6.1 - Create a Map<String,Integer> for counts in each state
        Map<String, Integer> personCountMap = countPersonInEachState(people);

        // Step 6.2 - Print state and counts
        printPersonCountsInState(personCountMap);
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


    public static List<Person> sortPeopleByFirstName(List<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        return people;
    }

    public static List<Person> sortPeopleByCompanyName(List<Person> people){
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getCompanyName().compareTo(o2.getCompanyName());
            }
        });

        return people;
    }

    public static List<Person> filterPersonsByState(List<Person> people, String state){

        List<Person> filteredPeople = new ArrayList<>();

        for (Person person: people){
            if (person.getState().equalsIgnoreCase(state)){
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }


    public static List<Person> filterPersonsByLastName(List<Person> people, String lastNameStartsWith){

        List<Person> filteredPeople = new ArrayList<>();

        for (Person person: people){
            if (person.getLastName().startsWith(lastNameStartsWith)){
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public static List<Person> filterPersonsByFirstName(List<Person> people, String firstNameStartsWith){

        List<Person> filteredPeople = new ArrayList<>();

        for (Person person: people){
            if (person.getFirstName().startsWith(firstNameStartsWith)){
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public static void printAll(List<Person> people){
        // Pre-Action Before Main Action
        System.out.println("All People Data");
        // Filler for Pre-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        System.out.println();

        // Main Action
        for (Person person : people){
            System.out.println(person);
        }

        // Post-Action After Main Action
        // Filler for Pre-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        System.out.println();
    }

    public static void printAllFirstNameStartsWith(List<Person> people, String startWith){

        // Pre-Action Before Main Action
        System.out.println("All People Data First Name Start with::"+startWith);
        // Filler for Pre-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        System.out.println();

        // Main Action
        for (Person person : people){
            if (person.getFirstName().startsWith(startWith))
                System.out.println(person);
        }

        // Post-Action After Main Action
        // Filler for Post-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");

        System.out.println();
        System.out.println();
    }

    public static void printAllLastNameStartsWith(List<Person> people, String startWith){
        // Pre-Action Before Main Action
        System.out.println("All People Data Last Name Start with::"+startWith);

        // Filler for Pre-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        System.out.println();

        // Main Action
        for (Person person : people){
            if (person.getLastName().startsWith(startWith))
                System.out.println(person);
        }

        // Post-Action After Main Action

        // Filler for Post-Action Heading
        for (int i=1 ; i<= 100; i++)
            System.out.print("#");
        System.out.println();
        System.out.println();
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
}
