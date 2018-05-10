package sparshcoolapps.lambdaexamples.Ex2InterfaceDemo;

import amdocs.demoppt.common.DataHelper;
import amdocs.demoppt.common.Person;
import amdocs.demoppt.common.PrintFormatter;
import amdocs.demoppt.common.SimpleFormatter;

import java.io.IOException;
import java.util.*;

interface Condition{
    boolean check (Person person);
}

public class PersonClient {

    public static void main(String ...args) throws IOException{

        // Get the People data
        List<Person> people = DataHelper.getPeople();

        // Common Fromatter
        PrintFormatter hashFormatter = new SimpleFormatter("#");
        PrintFormatter starFormatter = new SimpleFormatter("*");
        PrintFormatter starHashFormatter = new SimpleFormatter("*#");

        // Step - 1 print All People and some more based on some conditions
        Condition allPeople = new Condition() {
            @Override
            public boolean check(Person person) {
                return true;
            }
        };
        printConditionally(people, allPeople, hashFormatter, "All Persons Data");

        // Step - 2 print All People whose first name start with A
        Condition firstNameStartWithA = new Condition() {
            @Override
            public boolean check(Person person) {
                return person.getFirstName().startsWith("A");
            }
        };
        printConditionally(people, firstNameStartWithA, starFormatter, "Persons Whose First Name Start's with A");

        // Step - 3 print All People whose last name start with A
        Condition lastNameStartWithA = new Condition() {
            @Override
            public boolean check(Person person) {
                return person.getLastName().startsWith("A");
            }
        };
        printConditionally(people, lastNameStartWithA, starHashFormatter, "Persons Whose Last Name Start's with A");

        // Bonus Step - print All People whose last name start with A and First name with B
        Condition abName = new Condition() {
            @Override
            public boolean check(Person person) {
                return person.getLastName().startsWith("A") && person.getFirstName().startsWith("B");
            }
        };
        printConditionally(people, abName, starHashFormatter, "Persons Whose Last Name Start's with A and first name with B");

        // Bonus Step - print All People whose state name start with N
        Condition stateNameN = new Condition() {
            @Override
            public boolean check(Person person) {
                return person.getState().startsWith("N");
            }
        };
        printConditionally(people, stateNameN, starHashFormatter, "Persons Whose Sate Name Start's with N");

        // Step - 4 print All People in sorted order by last name whose first name start with A
        // Step - 4.1 filter all the records whose first name start with A
        List<Person> filteredPersonsByFirstName = filterConditionally(people,firstNameStartWithA);

        // Step - 4.2 Sort the filtered records from new Collections
        filteredPersonsByFirstName = sortPeopleByLastName(filteredPersonsByFirstName);

        // Step - 4.3 print all the filtered and sorted records from new Collections
        printConditionally(filteredPersonsByFirstName,allPeople,starHashFormatter,"People Sorted by Last Name whose First Name Start with A");

        // Step - 5 print All People in sorted order by their Company whose last name start with A

        // Step - 5.1 filter all the records whose last name start with A
        List<Person> filteredPersonsByLastName = filterConditionally(people, lastNameStartWithA);

        // Step - 5.2 Sort the filtered records from new Collections
        filteredPersonsByLastName = sortPeopleByCompanyName(filteredPersonsByLastName);

        // Step - 5.3 print all the filtered and sorted records from new Collections
        printConditionally(filteredPersonsByLastName,allPeople,starHashFormatter,"People Sorted by Company Name whose Last Name Start with A");


        // Step - 6 Print All People in sorted order by their Company whose state is NY

        // Step - 6.1 filter all the records whose state is NY
        List<Person> filteredPersonsBySate = filterConditionally(people, new Condition(){
            @Override
            public boolean check(Person person) {
                return person.getState().equalsIgnoreCase("NY");
            }
        });

        // Step - 6.2 Sort the filtered records from new Collections
        filteredPersonsBySate = sortPeopleByCompanyName(filteredPersonsBySate);

        // Step - 6.3 print all the filtered and sorted records from new Collections
        printConditionally(filteredPersonsBySate,allPeople,starFormatter,"People Sorted by Company Name whose State is NY");

        // Ex: 7 - Can you print how many persons belongs to each state?

        // Step 7.1 - Create a Map<String,Integer> for counts in each state
        Map<String, Integer> personCountMap = countPersonInEachState(people);

        // Step 7.2 - Print state and counts
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

    public static List<Person> sortPeopleByLastName(List<Person> people){
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

    private static List<Person> filterConditionally(List<Person> people, Condition condition){

        List<Person> filteredPeople = new ArrayList<>();

        for (Person p : people){
            if (condition.check(p)){
                filteredPeople.add(p);
            }
        }

        return filteredPeople;
    }

    public static void printConditionally(List<Person> people, Condition condition, PrintFormatter formatter, String msg){
        formatter.prePrint(msg);

        for (Person p : people){
            if (condition.check(p)){
                System.out.println(p);
            }
        }
        formatter.postPrint();
    }
}



