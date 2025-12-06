package my.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumbersExactallyTwice {
    void main() {

        List<Integer> numbers = List.of(
                5, 3, 9, 3, 8, 5, 1, 7, 8, 2, 4, 6, 2, 9, 9
        );
        List<Integer> list = numbers.stream().collect(
                        Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .filter(e -> e.getValue() == 2)
                .map(Map.Entry::getKey)
                .toList();

        IO.println(list);
    }


}
