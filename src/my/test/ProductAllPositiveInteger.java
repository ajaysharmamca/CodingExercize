package my.test;

import java.util.List;

public class ProductAllPositiveInteger {
//   Given a list of integers, return the product of all positive numbers.

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, 4, 2, -7, 5, 0, 9);
        int multiply = numbers.stream()
                .filter(n -> n > 0)
                .reduce(1, (a, b) -> a * b);
        System.out.printf("Sum of positive integers: %d%n", multiply);

    }
}
