package my.test;
/*
    Convert a list of numbers to a comma-separated string but skip numbers > 100
*/

import java.util.List;
import java.util.stream.Collectors;

public class CommaSeperatedGreaterThen100 {
    void main() {
        List<Integer> numbers = List.of(
                10,
                45,
                150,
                80,
                250,
                99,
                101,
                60
        );


        String string = numbers.stream()
                .filter(n -> n <= 100)
                .map(String::valueOf)
                .collect(
                        Collectors.joining(",")
                );

        IO.println(string);
    }


}
