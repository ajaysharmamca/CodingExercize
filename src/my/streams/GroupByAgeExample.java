package my.streams;

import my.Employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByAgeExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sunil", 30, "Male", "IT", 2015, 50000),
                new Employee(2, "Anjali", 25, "Female", "HR", 2018, 40000),
                new Employee(3, "Rishu", 10, "Male", "Finance", 2016, 55000),
                new Employee(4, "Nisha", 28, "Female", "IT", 2017, 48000),
                new Employee(5, "Shivam", 25, "Male", "HR", 2019, 42000));

                Map<Integer, List<Employee>> groupByAge = employees.parallelStream().collect(Collectors.groupingBy(Employee::age));
        System.out.println(groupByAge);
    }
}