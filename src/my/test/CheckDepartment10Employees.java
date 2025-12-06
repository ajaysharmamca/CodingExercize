package my.test;

import java.util.List;
import java.util.stream.Collectors;

//Given a list of employees, check whether any department has more than 10 employees.
public class CheckDepartment10Employees {
    void main() {

        List<Employee> employees = List.of(
                new Employee("Ajay",     "IT"),
                new Employee("Meena",    "IT"),
                new Employee("Suresh",   "HR"),
                new Employee("Kavita",   "HR"),
                new Employee("Pooja",    "Finance"),
                new Employee("Aman",     "Finance"),
                new Employee("Rohit",    "IT"),
                new Employee("Anita",    "HR"),
                new Employee("Rahul",    "IT"),
                new Employee("Arjun",    "Finance"),
                new Employee("Sneha",    "IT"),
                new Employee("Rita",     "Finance"),
                new Employee("Vikram",   "HR"),
                new Employee("Nisha",    "Finance"),
                new Employee("Karan",    "IT"),
                new Employee("Divya",    "HR"),
                new Employee("Manish",   "IT"),
                new Employee("Neha",     "Finance"),
                new Employee("Tarun",    "IT"),
                new Employee("Alka",     "HR"),
                new Employee("Ramesh",   "IT")
        );
        boolean b = employees.stream().collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .anyMatch(e -> e.getValue() > 10);

        System.out.println("10 Employess in a department : " + b);



    }


    private record Employee(String name, String department) {
    }


}


