package my.test;/*
 */


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Convert a list of strings to uppercase, then sort and remove duplicates
 */
public class UpperSortRemove {

    void main() {
        List<String> employees = List.of(
                "Ajay",
                "Rahul",
                "Meena",
                "Ajay",
                "Suresh",
                "Kavita",
                "Anita",
                "Anita",
                "Rohit",
                "Priya",
                "Vikas",
                "Arjun",
                "Vikas",
                "Aazaam"
        );
        LinkedHashSet<String> list = employees.stream().map(String::toUpperCase).collect(Collectors.toCollection(
                LinkedHashSet::new
        ));

        System.out.println(new ArrayList<>(list));
    }


}
