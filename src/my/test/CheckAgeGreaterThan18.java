package my.test;
/*
    Given a list of Person(name, age), check if all are adults (age ≥ 18).
*/

import java.util.List;

public class CheckAgeGreaterThan18 {
    void main() {
        List<Person> persons = List.of(
                new Person("Ajay", 25),
                new Person("Meena", 19),
                new Person("Suresh", 32),
                new Person("Kavita", 21),
                new Person("Rahul", 18)
        );
        boolean b = persons.stream().allMatch(e -> e.age >= 18);

        IO.println(b);
    }

    record Person(String name, int age) {

    }
}
