package my.test;/*

Given a list of integers, find the second highest and second lowest number.
 */


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Given a list of employees, return a map:
 *
 * Department → List of Employee Names (only names).
 *
 */
public class DepartmentEmplyees {

    void main() {
        List<Employee> employees1 = List.of(
                Employee.of("Ajay", "Math"),
                Employee.of("Rajesh", "Physics"),
                Employee.of("Minakshi", "Math"),
                Employee.of("Priya", "Physics")
        );
        HashMap<String, List<String>> byDepartment = employees1.stream().collect(Collectors.groupingBy(e -> e.department , HashMap::new,  Collectors.mapping(emp -> emp.name, Collectors.toList())));
        System.out.println(byDepartment);
    }

    record Employee(String name, String department) {
        // Compact constructor
        public Employee {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (department == null || department.isBlank()) {
                throw new IllegalArgumentException("Department cannot be empty");
            }
        }

        static Employee of(String name, String department) {
            return new Employee(name, department);
        }
    }
}
