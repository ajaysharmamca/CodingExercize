package my.test;

import java.util.List;

public class PerfectSquare {

    static void main() {
        //Given a list of integers, detect if any number is a perfect square.
        List<Integer> numbers = List.of(
                2, 3, 5, 7, 10,
                12, 15, 16, 18,
                20, 25, 27
        );
        boolean list = numbers.stream().anyMatch(PerfectSquare::isPerfectSquare);
        System.out.printf(" Perfect squares %s", list);
    }

    private static boolean isPerfectSquare(int number) {
        int root = (int)  Math.sqrt(number);
        return (root * root) == number;

    }
}
