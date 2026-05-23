package my.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimePartition {
   // Given a list of integers, separate prime and composite numbers using partitioningBy().

    static void main() {
        List<Integer> numbers = List.of(
                1, 2, 3, 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14, 15,
                16, 17, 18, 19, 20
        );

        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(PrimePartition::isPrime));
        System.out.println(collect);
    }

    static boolean isPrime(int n) {
        return n > 1 &&
                IntStream.rangeClosed(2, (int)Math.sqrt(n))
                        .noneMatch(i -> n % i == 0);
    }
}