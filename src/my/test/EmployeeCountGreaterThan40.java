package my.test;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EmployeeCountGreaterThan40 {
//    Given a list of employees, return a map:
//
//    Department → Count of employees older than 40.
    public static void main(String[] args) {
        record Employee(String name, String department, int age) {}

        List<Employee> employees = List.of(
                new Employee("Ajay", "IT", 28),
                new Employee("Meena", "IT", 42),
                new Employee("Suresh", "HR", 45),
                new Employee("Kavita", "HR", 39),
                new Employee("Ramesh", "Finance", 50),
                new Employee("Anita", "Finance", 41),
                new Employee("Vikram", "IT", 44),
                new Employee("Pooja", "Admin", 38),
                new Employee("Manoj", "Admin", 47)
        );
        TreeMap<String, Long> collect = employees.stream()
                .filter(e->e.age > 40)
                .collect(
                        Collectors.groupingBy(
                                e -> e.department,
                                TreeMap::new,
                                Collectors.counting()
                        )
                );
        System.out.println(" Tree MAp : " + collect );
    }
}
