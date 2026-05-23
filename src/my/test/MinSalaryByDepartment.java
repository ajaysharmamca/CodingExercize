package my.test;

import java.util.*;
import java.util.stream.Collectors;

public class MinSalaryByDepartment {
    record Employee(String name, String department, int salary) {}

    static void main() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 5000));
        employees.add(new Employee("Bob", "HR", 4500));
        employees.add(new Employee("Charlie", "IT", 7000));
        employees.add(new Employee("David", "IT", 6500));
        employees.add(new Employee("Eve", "Finance", 6000));
        employees.add(new Employee("Frank", "Finance", 5500));

        TreeMap<String, String> collect = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::department,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                            Collectors.minBy(Comparator.comparing(Employee::salary)),
                            opt -> opt.map(e-> e.name).orElse("None")
                )
        ));
        System.out.println(collect);
    }
}
