package my.test;

import java.util.List;
import java.util.stream.IntStream;

public class StrictallyIncreasingList {
//    Given a list of integers, check if the list is strictly increasing using streams.
    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5); // strictly increasing
        List<Integer> numbers2 = List.of(1, 2, 2, 3, 4); // not strictly increasing
        List<Integer> numbers3 = List.of(5, 10, 15, 20); // strictly increasing
        List<Integer> numbers4 = List.of(3, 2, 4, 5); // not strictly increasing
        List<Integer> numbers5 = List.of(1, 3, 5, 7, 9); // strictly increasing
        IO.println(listStrictallyIncreasing(numbers1));
        IO.println(listStrictallyIncreasing(numbers2));
    }

    private static Object listStrictallyIncreasing(List<Integer> numbers) {
        return IntStream.range(1, numbers.size()).allMatch(i -> numbers.get(i - 1) < numbers.get(i));
    }


}
