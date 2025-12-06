package my.test;/*
    Check if any element in a list appears more than 5 times.
    Use anyMatch() with frequency logic.
*/

import java.util.Collections;
import java.util.List;

public class ElementsAppearMoreThanOne {
    void main() {
        List<Person> persons = List.of(
                new Person("Ajay", 25),
                new Person("Meena", 19),
                new Person("Suresh", 32),
                new Person("Kavita", 21),
                new Person("Rahul", 18)
        );
        boolean check = persons.stream().anyMatch(n -> Collections.frequency(persons, "Ajay") >= 5);
        System.out.println(check);
    }

    record Person(String name, int age) {

    }
}
