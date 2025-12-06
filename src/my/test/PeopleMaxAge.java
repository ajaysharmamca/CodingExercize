package my.test;/*
 */


import java.util.Comparator;
import java.util.List;

/**
 * Given a list of people (name, age), return the oldest 2
 */
public class PeopleMaxAge {

    void main() {
        List<Person> persons = List.of(
                new Person("Ajay", 45),
                new Person("Rahul", 32),
                new Person("Meena", 51),
                new Person("Suresh", 28),
                new Person("Kavita", 60),
                new Person("Anita", 43),
                new Person("Rohit", 55)
        );

        List<Person> list = persons.stream()
                .sorted(Comparator
                        .comparingInt(Person::age).reversed()
                        .thenComparing(Person::name))
                .limit(2)
                .toList();
        System.out.println(list);
    }


    private record Person(String name, int age) {
    }


}
