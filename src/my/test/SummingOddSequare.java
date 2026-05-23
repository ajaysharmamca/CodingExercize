package my.test;

import java.util.List;

public class SummingOddSequare {

    void main() {
//     From a list of integers, compute the sum of squares of only odd numbers.
        List<Integer> numbers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15
        );
        Integer collect = numbers.stream().filter(n -> n % 2 != 0).mapToInt(n -> n * n).sum();
        System.out.println(collect);
    }


}
