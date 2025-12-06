package my.test;/*
 */


import java.util.Comparator;
import java.util.List;

/**
 * Given a list of strings, sort them by length then alphabetically.
 */
public class LenghtThenNatural {

    void main() {
        List<String> employees = List.of(
                "Ajay",
                "Rahul",
                "Meena",

                "Suresh",
                "Kavita",
                "Rohit",

                "Anita",
                "Priya",

                "Arjun",
                "Vikas",
                "Aazaam"
        );
        List<String> list = employees.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();

        System.out.println("" + list);
    }


}
