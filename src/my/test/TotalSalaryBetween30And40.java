package my.test;

import java.util.List;

public class TotalSalaryBetween30And40 {
//    Given a list of employees, return the total salary of employees whose age is between 30 and 40.
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Ajay", 28, 50000),
                new Employee("Meena", 32, 75000),
                new Employee("Suresh", 35, 60000),
                new Employee("Kavita", 40, 72000),
                new Employee("Ramesh", 45, 80000),
                new Employee("Anita", 38, 68000),
                new Employee("Vikram", 29, 55000)
        );
        int sum = employees.stream().filter(e -> e.age >= 30 && e.age <= 40).mapToInt(Employee::salary).sum();
        System.out.printf("Total salary: %d%n", sum);
    }

    record Employee(String name, int age, int salary) {}
}
