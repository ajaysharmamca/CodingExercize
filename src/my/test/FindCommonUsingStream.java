package my.test;
/*
    Convert a list of numbers to a comma-separated string but skip numbers > 100
*/

import java.util.List;

public class FindCommonUsingStream {
    void main() {
        List<Person> persons = List.of(
                new Person("Ajay", 25),
                new Person("Meena", 19),
                new Person("Suresh", 32),
                new Person("Kavita", 21),
                new Person("Rahul", 18)
        );

        List<Person> persons1 = List.of(
                new Person("Ajay", 25),
                new Person("Meena1", 19),
                new Person("Suresh", 32),
                new Person("Kavita1", 21),
                new Person("Rahul1", 18)
        );
        List<Person> list = persons.stream().filter(persons1::contains).toList();
        // Given two lists, find common elements using streams.

        IO.println(list);
    }

    record Person(String name, int age) {

    }
}
