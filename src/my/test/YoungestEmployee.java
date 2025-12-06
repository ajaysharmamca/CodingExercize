package my.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *    Given a list of employees, return the youngest employee in each department.
 */
public class YoungestEmployee {
    void main() {

        List<Employee> employees = List.of(
                new Employee(1, "Ajay", 1, 28),
                new Employee(2, "Rahul", 1, 32),
                new Employee(3, "Kiran", 1, 25),
                new Employee(4, "Meena", 1, 30),

                new Employee(5, "Arun", 2, 29),
                new Employee(6, "Suman", 2, 24),
                new Employee(7, "Neha", 2, 27),

                new Employee(8, "Ravi", 3, 31),
                new Employee(9, "Pooja", 3, 26),
                new Employee(10, "Anita", 3, 34));


        Map<Integer, Employee> collect = employees.stream().collect(Collectors.groupingBy(
                Employee::departmentId,
                Collectors.collectingAndThen(
                        Collectors.minBy(Comparator.comparingInt(Employee::age)),
                        Optional::get
                )
        ));


        System.out.println(collect);
    }

    record Employee(int id, String name, int departmentId, int age) {

    }
}