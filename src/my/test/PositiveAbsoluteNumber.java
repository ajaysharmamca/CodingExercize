package my.test;

import java.util.List;

public class PositiveAbsoluteNumber {
    void main() {
        List<Integer> numbers = List.of(-5, 3, -2, 0, 7);
        List<Integer> list = numbers.stream()
                .filter(e -> e >= 0)
                .map(Math::abs)
                .toList();
        System.out.println(list);
    }




}