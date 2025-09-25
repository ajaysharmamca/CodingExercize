package object;

import Employee.Employee1;

import java.util.*;


public class InfosysTest {
    public static void main(String[] args) {
        List<Employee1> list = new ArrayList<>();
        list.add(new Employee1(1, "Ravi", 50000));
        list.add(new Employee1(2, "Anita", 70000));
        list.add(new Employee1(3, "Kiran", 50000));
        list.stream()
            .sorted(Comparator.comparingDouble(Employee1::salary)
                    .reversed()
                    .thenComparing(Employee1::name))
            .forEach(System.out::println);
    }
}