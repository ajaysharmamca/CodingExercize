package my.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the highest-paid employee in each department.
 */
public class HighestPaidEmployee {

    void main() {
        List<Employee> employees = List.of(
                Employee.ofEmployee(1,  "Ajay",      "IT",         5000),
                Employee.ofEmployee(2,  "Rahul",     "IT",         6200),
                Employee.ofEmployee(3,  "Meena",     "IT",         5800),

                Employee.ofEmployee(4,  "Suresh",    "HR",         4500),
                Employee.ofEmployee(5,  "Kavita",    "HR",         5200),
                Employee.ofEmployee(6,  "Anita",     "HR",         5100),

                Employee.ofEmployee(7,  "Rohit",     "Finance",    7000),
                Employee.ofEmployee(8,  "Priya",     "Finance",    6800),

                Employee.ofEmployee(9,  "Arjun",     "Sales",      4000),
                Employee.ofEmployee(10, "Vikas",     "Sales",      7500),
                Employee.ofEmployee(11, "Neha",      "Sales",      7200)
        );
        Map<String, Employee> collect = employees.stream().collect(
                Collectors.groupingBy(Employee::department,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Employee::salary)),
                                Optional::get
                        )));

        System.out.println(collect);
    }

    record Employee(int id, String name, String department, double salary) {
        public static Employee ofEmployee(int id, String name, String department, double salary) {
            return new Employee(id, name, department, salary);
        }
    }
}