package my.test;

import java.util.Arrays;
import java.util.List;

public class PairNumbers {

    public static void main(String[] args) {
//        Given a list of integers, return all pairs (i, j) where i < j and i + j = target.
        List<Integer> numbers = Arrays.asList(
                2, 7, 10, -1
        );
        int target = 9;
        numbers.stream().flatMap(
                i -> numbers.stream()
                        .filter(j -> i < j)
                        .filter(j-> (int) (j + i) == target)
                        .map(j -> "(" + i + ", " + j + ")")
                )
                .forEach(System.out::println);


    }

}
