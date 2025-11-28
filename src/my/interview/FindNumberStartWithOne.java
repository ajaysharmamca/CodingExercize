package my.interview;

import java.util.List;
import java.util.stream.Collectors;

public class FindNumberStartWithOne {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().map( String::valueOf ).filter( e -> e.charAt(0) == '1' ).collect(Collectors.toList());
        numbers.stream().filter(n-> firstDigit(n) == 1).forEach(System.out::println);
    }


    private static int firstDigit(int n) {
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }
}
