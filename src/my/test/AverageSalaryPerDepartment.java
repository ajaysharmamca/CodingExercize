package my.test;/*
count number of all subarrays in an array with given sum K
Given an array arr[] of postive and negative integers, find the number of subarrays having a sum exactly equal to a given number k.

Examples:
 Input : arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output : 2
Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.

Input : arr[] = [10, 2, -2, -20, 10], k = -10
Output : 3
Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.


Input arr = {1, -1, 1, -1, 1} k=0
Output: arr[0...1], arr[2...3], arr[0...3]
log (n2)

Given a list of integers, find the second highest and second lowest number.
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a list of employees, group them by department and find average salary per department.
 *
 */
public class AverageSalaryPerDepartment {

    void main() {
        List<Employee> citizens = List.of(
                                            Employee.of(3, "IT", 30.0),
                                            Employee.of(4, "IT", 100.00),
                                            Employee.of(5, "Finance", 200.00)
                                        );
        Map<String, Double> averageSalary = citizens.stream()
                .collect(Collectors.groupingBy(
                        e->e.department, HashMap::new, Collectors.averagingDouble(e->e.salary)
                ));
        System.out.println(averageSalary);
    }

    record Employee(int id, String department, double salary) {
        static Employee of(int id, String department, double salary) {
            return new Employee(id, department, salary);
        }
    }
}
