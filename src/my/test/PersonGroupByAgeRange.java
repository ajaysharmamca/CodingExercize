package my.test;

import java.util.*;
import java.util.stream.Collectors;

public class PersonGroupByAgeRange {
    record Person(String name, int age) {}
    static void main() {
//        Given a list of people, group by age bracket (20–29, 30–39, etc.) using groupingBy().


        List<Person> people = Arrays.asList(
                new Person("Ajay", 22),
                new Person("Meera", 27),
                new Person("Ravi", 29),

                new Person("Suresh", 31),
                new Person("Kiran", 35),
                new Person("Divya", 38),

                new Person("Vinod", 41),
                new Person("Lakshmi", 44),
                new Person("Rahul", 48),

                new Person("Anita", 52),
                new Person("Gopal", 56),

                new Person("Mohan", 60),
                new Person("Saritha", 63)
        );
        Map<String, List<Person>> personsBucket = new HashMap<>();

        TreeMap<String, List<Person>> collect = people.stream().collect(
                Collectors.groupingBy(
                        PersonGroupByAgeRange::getBucketName,
                        TreeMap::new,
                        Collectors.mapping(p -> p, Collectors.toList())
                )
        );
        System.out.println(collect);

    }

    private static String getBucketName(Person person) {
        int start = (person.age / 10) * 10;
        int end = start + 9;
        return start + "-" + end;
    }
}
