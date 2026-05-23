package my.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilterByNull {

    public static void main(String[] args) {
//        Given a list of objects, remove all null fields using Optional + streams. Give data for this problem java code
        record Person(String name, Integer age, String email) {}

        List<Person> peoples = Arrays.asList(
                new Person("Ajay", 25, "ajay@gmail.com"),
                new Person(null, 30, "ravi@yahoo.com"),
                new Person("Meera", null, "meera@gmail.com"),
                new Person("Tom", 40, null),
                new Person(null, null, null),
                new Person("Sara", 28, "sara@company.org")
        );
        List<Person> list = peoples.stream()
                .filter(p -> Optional.ofNullable(p.name()).isPresent())
                .filter(p -> Optional.ofNullable(p.age()).isPresent())
                .filter(p -> Optional.ofNullable(p.email()).isPresent())
                .toList();
        System.out.printf("List og persons: %s%n", list);
    }
}
