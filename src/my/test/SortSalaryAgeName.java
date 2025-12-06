package my.test;

import java.util.Comparator;
import java.util.List;

/**
 *    Sort a list of custom objects by multiple fields in this order:
 *
 * Salary (desc), Age (asc), Name (asc).
 */
public class SortSalaryAgeName {
    void main() {
        List<Employee> employees = List.of(
                new Employee(1, "Rahul", 28, 90000, "IT"),
                new Employee(2, "Meena", 25, 90000, "IT"),
                new Employee(3, "Suresh", 30, 85000, "HR"),
                new Employee(4, "Anita", 28, 85000, "HR"),
                new Employee(5, "Pooja", 26, 85000, "HR"),
                new Employee(6, "Arjun", 32, 75000, "Finance"),
                new Employee(7, "Aman", 29, 75000, "Finance"),
                new Employee(8, "Kavita", 27, 60000, "IT"),
                new Employee(9, "Rohit", 27, 60000, "Finance")
        );
        List<Employee> list = employees.stream().sorted(
                Comparator.comparingInt(Employee::salary).reversed()
                        .thenComparing(Employee::age)
                        .thenComparing(Employee::age)
        ).toList();

        System.out.println(list);
    }

    record Employee(int id, String name, int age, int salary, String department) { }


}