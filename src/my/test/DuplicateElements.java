package my.test;/*
count number of all subarrays in an array with given sum K

 */


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  Find duplicate elements in a list using streams.
 *
 */
public class DuplicateElements {

    void main() {
        List<Employee> employees1 = List.of(
                Employee.of("Ajay", "Math"),
                Employee.of("Rajesh", "Physics"),
                Employee.of("Minakshi", "Math"),
                Employee.of("Ajay", "Math")
        );
        List duplicates =  employees1.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue() > 1 )
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicates);
    }

    record Employee(String name, String department) {
        static Employee of(String name, String department) {
            return new Employee(name, department);
        }
    }



}
