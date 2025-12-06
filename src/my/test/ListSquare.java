package my.test;/*
 */


import java.util.List;

/**
 *   Convert a list of integers to a list of squares and remove those divisible by 3.
 *
 */
public class ListSquare {

    void main() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> list = numbers.stream().map(e -> e * e).filter(e -> e % 3 != 0).toList();
        System.out.println(list);
    }
}
