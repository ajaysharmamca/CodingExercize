package my.test.imp;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SecondHighestSalary {

    //Second Highest salary on every department
    record Employee (String name, String department, int salary) {}
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Ajay", "Sales", 1000),
                new Employee("Ram", "Sales", 2000),
                new Employee("Amit", "Sales", 1500),
                new Employee("Ravi", "IT", 3000),
                new Employee("Raja", "IT", 2800));

        TreeMap<String, List<Integer>> deparmentSalary = employees.stream().collect(
                Collectors.groupingBy(
                        e->e.department,
                        TreeMap::new,
                        Collectors.mapping(Employee::salary, Collectors.toList())
                )
        );

        Map<String, Integer> collect = deparmentSalary.entrySet()
                .stream()
                .filter(e -> e.getValue().size() >= 2)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst()
                                .orElse(null)
                ));
        System.out.println(collect);

    }


}
