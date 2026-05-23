package my.test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SummingArray {
//   Given a list of numbers, return a list of running sums using streams.
//
//Input: [1,2,3,4] → [1,3,6,10].

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> running =
                input.stream()
                        .map(sum::addAndGet)
                        .toList();
        System.out.println(running);

    }
}
